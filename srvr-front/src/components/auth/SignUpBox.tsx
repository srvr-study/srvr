import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import styled, { ThemeContext, ThemeProps } from "styled-components";

import { AuthBoxWrapper } from "./AuthContainer";

import { joinApi } from "@apis/authApi";
import { TextBoxButton, TextButton } from "@components/common/Button";
import { IconRoundInput } from "@components/common/Input";
import { ContentTitle } from "@components/common/PageTemplate";
import { lightTheme, Theme } from "@constants/theme";
import { I18nContext } from "@providers/I18nProvider";

import usernameDark from "@assets/icons/auth/username-dark.svg";
import usernameLight from "@assets/icons/auth/username-light.svg";
import emailDark from "@assets/icons/auth/email-dark.svg";
import emailLight from "@assets/icons/auth/email-light.svg";
import passwordDark from "@assets/icons/auth/password-dark.svg";
import passwordLight from "@assets/icons/auth/password-light.svg";


export function SignUpBox(): JSX.Element {
  const { theme } = useContext(ThemeContext);
  const authText = useContext(I18nContext).i18n.auth;
  
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [repassword, setRepassword] = useState("");
  const [errorMessage, setErrorMessage] = useState(authText.signUpText.siteCautionMessage);
  const navigate = useNavigate();

  const join = async () => {
    const responseBody = await joinApi({ username, email, password, role: "MEMBER" });

    if(responseBody.header.isSuccessful) {
      navigate("/auth/login");
    } else {
      
    }
  };

  return (
    <SignUpWrapper width="460px">
      <ContentTitle>Sign Up</ContentTitle>
      <IconRoundInput
        src={theme === lightTheme ? usernameLight : usernameDark}
        value={username}
        placeholder={authText.signUpText.usernamePlaceHolder}
        onChange={({ target }) => setUsername(target.value)}
      />
      <IconRoundInput
        src={theme === lightTheme ? emailLight : emailDark}
        value={email}
        placeholder={authText.signUpText.emailPlaceHolder}
        type="email"
        onChange={({ target }) => setEmail(target.value)}
      />
      <IconRoundInput
        src={theme === lightTheme ? passwordLight : passwordDark}
        value={password}
        placeholder={authText.signUpText.passwordPlaceHolder}
        type="password"
        onChange={({ target }) => setPassword(target.value)}
      />
      <IconRoundInput
        src={theme === lightTheme ? passwordLight : passwordDark}
        value={repassword}
        placeholder={authText.signUpText.repasswordPlaceHodler}
        type="password"
        onChange={({ target }) => setRepassword(target.value)}
      />
      <ErrorMeeage>{errorMessage}</ErrorMeeage>
      <TextBoxButton text={authText.signUpText.joinText} width={"460px"} onClick={join} />
      <TextButton text={authText.signUpText.backText} onClick={() => navigate("/auth/login")} />
    </SignUpWrapper>
  );
}

const SignUpWrapper = styled(AuthBoxWrapper)`
  & .icon-round-input {
    margin-bottom: 30px;
  }

  & .text-box-button {
    margin-top: 26px;
    margin-bottom: 19px;
  }
`;

const ErrorMeeage = styled.p`
  width: 100%;
  margin-top: 6px;

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.md })}
  color: ${({ theme }: ThemeProps<Theme>) => theme.color.red};
`;
