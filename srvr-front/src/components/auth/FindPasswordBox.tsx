import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import styled, { ThemeContext, ThemeProps } from "styled-components";

import { AuthBoxWrapper } from "./AuthContainer";

import { checkVerifiactionCode, requestVerificationCodeMail } from "@apis/authApi";
import { TextBoxButton, TextButton } from "@components/common/Button";
import { IconRoundInput } from "@components/common/Input";
import { ContentTitle } from "@components/common/PageTemplate";
import { lightTheme, Theme } from "@constants/theme";

import emailDark from "@assets/icons/auth/email-dark.svg";
import emailLight from "@assets/icons/auth/email-light.svg";
import passwordDark from "@assets/icons/auth/password-dark.svg";
import passwordLight from "@assets/icons/auth/password-light.svg";


export function FindPasswordBox(): JSX.Element {
  const { theme } = useContext(ThemeContext);
  const [email, setEmail] = useState<string>("");
  const [code, setCode] = useState<string>("");
  const [errorMessage, setErrorMessage] = useState<string>("");
  const [getCode, setGetCode] = useState<Boolean>(false);
  const navigate = useNavigate();

  function sendEmail() {
    requestVerificationCodeMail(email).then(body => body.header.isSuccessful && setGetCode(true));
  }

  function checkCode() {
    checkVerifiactionCode({email, code}).then(body => {
      if (body.header.isSuccessful) {
        navigate("/auth/reset-password")
      } else {
        // todo 실패 모달을 띄우기
        setCode("");
      }
    });
  }

  return (
    <FindPasswordBoxWrapper width={"460px"}>
      <ContentTitle>Find Password</ContentTitle>
      <IconRoundInput
        src={theme === lightTheme ? emailLight : emailDark}
        value={email}
        placeholder={"E - mail을 입력해주세요."}
        type="email"
        onChange={({ target }) => setEmail(target.value)}
      />
      {getCode && <IconRoundInput
        src={theme === lightTheme ? passwordLight : passwordDark}
        value={code}
        placeholder={"Code를 입력해주세요."}
        type="text"
        onChange={({ target }) => setCode(target.value)}
      />}
      <ErrorMeeage>{errorMessage}</ErrorMeeage>
      <TextBoxButton text={getCode ? "코드 다시 받기" : "코드받기"} width={"460px"} onClick={sendEmail} />
      {getCode && <TextBoxButton text={"확인"} width={"460px"} onClick={checkCode} />}
      <TextButton text={"돌아가기"} onClick={() => navigate("/auth/login")} />
    </FindPasswordBoxWrapper>
  );
}

const FindPasswordBoxWrapper = styled(AuthBoxWrapper)`
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
