import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import styled, { ThemeContext, ThemeProps } from "styled-components";

import { AuthBoxWrapper } from "./AuthContainer";

import { TextBoxButton, TextButton } from "@components/common/Button";
import { IconRoundInput } from "@components/common/Input";
import { ContentTitle } from "@components/common/PageTemplate";
import { lightTheme, Theme } from "@constants/theme";

import passwordDark from "@assets/icons/auth/password-dark.svg";
import passwordLight from "@assets/icons/auth/password-light.svg";


export function SuccessSignInBox(): JSX.Element {
  const { theme } = useContext(ThemeContext);
  const [password, setPassword] = useState<string>("");
  const [repassword, setRepassword] = useState<string>("");
  const [errorMessage, setErrorMessage] = useState<string>("");
  const navigate = useNavigate();

  return (
    <SuccessSignInBoxWrapper width={"460px"}>
      <ContentTitle>Reset Password</ContentTitle>
      <IconRoundInput
        src={theme === lightTheme ? passwordLight : passwordDark}
        value={password}
        placeholder={"Password을 입력해주세요."}
        type="password"
        onChange={({ target }) => setPassword(target.value)}
      />
      <IconRoundInput
        src={theme === lightTheme ? passwordLight : passwordDark}
        value={repassword}
        placeholder={"Password을 다시 입력해주세요."}
        type="password"
        onChange={({ target }) => setRepassword(target.value)}
      />
      <ErrorMeeage>{errorMessage}</ErrorMeeage>
      <TextBoxButton text={"비밀번호 저장"} width={"460px"} onClick={() => { }} />
      <TextButton text={"돌아가기"} onClick={() => navigate("/auth/login")} />
    </SuccessSignInBoxWrapper>
  );
}

const SuccessSignInBoxWrapper = styled(AuthBoxWrapper)`
  & .icon-round-input {
    margin-bottom: 30px;

    :last-child {
      margin-bottom: 0px;
    }
  }

  & .text-box-button {
    margin: 19px 0;

    &:first-child {
      margin-top: 31px;
    }
  }
`;

const ErrorMeeage = styled.p`
  width: 100%;
  margin-top: 6px;

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.md })}
  color: ${({ theme }: ThemeProps<Theme>) => theme.color.red};
`;