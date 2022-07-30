import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import styled, { ThemeContext, ThemeProps } from "styled-components";

import { AuthBoxWrapper } from "./AuthContainer";
import { OAuthContainer } from "./OAuthContainer";

import { lightTheme, Theme } from "@constants/theme";
import { TextBoxButton, TextButton } from "@components/common/Button";
import { IconRoundInput } from "@components/common/Input";
import { ContentTitle } from "@components/common/PageTemplate";

import { loginApi } from "@apis/authApi";
import usernameDark from "@assets/icons/auth/username-dark.svg";
import usernameLight from "@assets/icons/auth/username-light.svg";
import passwordDark from "@assets/icons/auth/password-dark.svg";
import passwordLight from "@assets/icons/auth/password-light.svg";
import { I18nContext } from "@providers/I18nProvider";


export function SignInBox(): JSX.Element {
  const { theme } = useContext(ThemeContext);
  const authText = useContext(I18nContext).i18n.auth;

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState(authText.signinInText.confirmUsernameAndPasswordMessage);
  const navigate = useNavigate();

  const login = async () => {
    const responseBody = await loginApi({ username, password });

    if (responseBody.header.isSuccessful) {
      navigate("/auth/success")
    }
  };

  return (
    <SignInBoxWrapper width="460px">
      <ContentTitle>Sign In</ContentTitle>
      <IconRoundInput
        src={theme === lightTheme ? usernameLight : usernameDark}
        value={username}
        type="text"
        placeholder={authText.signinInText.usernamePlaceHolder}
        onChange={({ target }) => setUsername(target.value)}
      />
      <IconRoundInput
        src={theme === lightTheme ? passwordLight : passwordDark}
        value={password}
        type="password"
        placeholder={authText.signinInText.passwordPlaceHolder}
        onChange={({ target }) => setPassword(target.value)}
      />
      <FindPasswordWrapper>
        <p>{authText.signinInText.findPasswordMessage}</p>
        <Link to={"/auth/find-password"}>{authText.signinInText.findPasswordText}</Link>
      </FindPasswordWrapper>
      <ErrorMessage>{errorMessage}</ErrorMessage>
      <OAuthContainer />
      <TextBoxButton text={authText.signinInText.loginText} width={"460px"} onClick={login} />
      <TextButton text={authText.signinInText.joinText} onClick={() => navigate("/auth/join")} />
    </SignInBoxWrapper>
  );
}


const SignInBoxWrapper = styled(AuthBoxWrapper)`
  & .icon-round-input {
    margin-bottom: 30px;

    :last-child {
      margin-bottom: 0px;
    }
  }

  & .text-box-button {
    margin-top: 61px;
    margin-bottom: 19px;
  }
`;

const FindPasswordWrapper = styled.div`
  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenter}

  width: 100%;
  justify-content: left;

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.md })}
  color: ${({ theme }: ThemeProps<Theme>) => theme.color.textPrimary};

  & a {
    margin-left: 5px;

    color: ${({ theme }: ThemeProps<Theme>) => theme.color.textPrimary};
    text-decoration: underline;
  }
`;

const ErrorMessage = styled.p`
  width: 100%;
  margin-top: 6px;

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.md })}
  color: ${({ theme }: ThemeProps<Theme>) => theme.color.red};
`
