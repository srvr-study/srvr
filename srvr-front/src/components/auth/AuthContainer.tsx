import styled from "styled-components";
import usernameDark from "@assets/icons/auth/username-dark.svg";
import usernameLight from "@assets/icons/auth/username-light.svg";
import emailDark from "@assets/icons/auth/email-dark.svg";
import emailLight from "@assets/icons/auth/email-light.svg";
import passwordDark from "@assets/icons/auth/password-dark.svg";
import passwordLight from "@assets/icons/auth/password-light.svg";
import { lightTheme } from "@constants/theme";
import React, { useContext, useEffect, useState } from "react";
import { ThemeContext } from "@providers/ThemeProvider";
import { joinApi, loginApi } from "@apis/authApi";

type Props = {
  type: string;
};

export function AuthContainer({ type }: Props): JSX.Element {
  const { theme, themeDispatch } = useContext(ThemeContext);
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [repassword, setRepassword] = useState("");
  const [isMatchPassword, setIsMatchPassword] = useState(true);

  const onChangeUsername = (e: React.ChangeEvent<HTMLInputElement>) => {
    setUsername(e.target.value);
  };

  const onChangeEmail = (e: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(e.target.value);
  };

  const onChangePassword = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(e.target.value);
  };

  const onChangeRepassword = (e: React.ChangeEvent<HTMLInputElement>) => {
    setRepassword(e.target.value);
    password !== e.target.value
      ? setIsMatchPassword(false)
      : setIsMatchPassword(true);
  };

  const login = async () => {
    const _res = await loginApi({ username, password });
  };

  const join = async () => {
    const _res = await joinApi({ username, email, password });
  };

  const joinPage = async () => {
    window.location.href = "/auth/join";
  };
  const backPage = async () => {
    window.location.href = "/auth/login";
  };

  useEffect(() => {
    setUsername("");
    setEmail("");
    setPassword("");
    setRepassword("");
  }, []);
  return (
    <Container>
      <LoginTitle>{type === "signIn" ? "Sign In" : "Sign Up"}</LoginTitle>
      <InputContainer>
        <ImgWrapper>
          <img src={theme == lightTheme ? usernameDark : usernameLight}></img>
        </ImgWrapper>
        <LoginInput
          placeholder="Username을 입력해주세요."
          value={username}
          onChange={onChangeUsername}
        ></LoginInput>
      </InputContainer>
      {type === "signUp" && (
        <InputContainer>
          <ImgWrapper>
            <img src={theme == lightTheme ? emailDark : emailLight}></img>
          </ImgWrapper>
          <LoginInput
            placeholder="E-mail을 입력해주세요."
            type="email"
            value={email}
            onChange={onChangeEmail}
          ></LoginInput>
        </InputContainer>
      )}
      <InputContainer>
        <ImgWrapper>
          <img src={theme == lightTheme ? passwordDark : passwordLight}></img>
        </ImgWrapper>
        <LoginInput
          placeholder="Password을 입력해주세요."
          type="password"
          value={password}
          onChange={onChangePassword}
        ></LoginInput>
      </InputContainer>
      {type === "signUp" && (
        <InputContainer>
          <ImgWrapper>
            <img src={theme == lightTheme ? passwordDark : passwordLight}></img>
          </ImgWrapper>
          <LoginInput
            placeholder="Password을 다시 입력해주세요."
            type="password"
            value={repassword}
            onChange={onChangeRepassword}
          ></LoginInput>
        </InputContainer>
      )}

      {type === "signUp" && !isMatchPassword && (
        <ErrorDiv>Password가 일치하지 않습니다.</ErrorDiv>
      )}

      <JoinButton onClick={type === "signIn" ? login : join}>
        {type === "signIn" ? "로그인" : "회원가입"}
      </JoinButton>
      <BackButton onClick={type === "signIn" ? joinPage : backPage}>
        {type === "signIn" ? "회원가입" : "돌아가기"}
      </BackButton>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  width: 350px;
  margin: 100px 0 0 40%;
`;

const LoginTitle = styled.div`
  font-size: 40px;
  font-weight: 500;

  color: ${({ theme }) => theme.color.secondary};
`;

const InputContainer = styled.div`
  display: flex;

  width: 100%;
  height: 60px;
  padding: 15px;
  margin-top: 30px;
  border: 1px solid ${({ theme }) => theme.color.secondary};
  border-radius: 40px;
`;

const ImgWrapper = styled.div`
  display: flex;
  align-items: center;

  width: 10%;
  border-right: 1px solid ${({ theme }) => theme.color.secondary};
`;

const LoginInput = styled.input`
  width: 80%;
  margin-left: 15px;
  border: 0 solid black;

  font-size: 15px;

  color: ${({ theme }) => theme.color.secondary};
  background: transparent;

  &:focus {
    outline: none;
  }

  &::placeholder {
    color: ${({ theme }) => theme.color.secondary};
  }
`;

const ErrorDiv = styled.div`
  margin: 30px 0px -20px 0px;
  color: ${({ theme }) => theme.color.red};
`;

const JoinButton = styled.button`
  width: 100%;
  height: 50px;
  margin-top: 50px;
  border-radius: 10px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  font-size: 18px;

  color: ${({ theme }) => theme.color.primary};
  background: ${({ theme }) => theme.color.secondary};
`;

const BackButton = styled.button`
  width: 100%;
  height: 50px;
  margin-top: 20px;

  font-size: 18px;

  color: ${({ theme }) => theme.color.secondary};
`;
