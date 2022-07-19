// import styled from "styled-components";

// import { lightTheme } from "@constants/theme";
// import React, { useContext, useEffect, useState } from "react";
// import { ThemeContext } from "@providers/ThemeProvider";
// import { joinApi, loginApi } from "@apis/authApi";

import { Theme } from "@constants/theme"
import styled, { ThemeProps } from "styled-components"

// type Props = {
//   type: string;
// };

// const EMPTY_STRING = "";

// export function AuthContainer({ type }: Props): JSX.Element {
//   const { theme, themeDispatch } = useContext(ThemeContext);
//   const [username, setUsername] = useState("");
//   const [email, setEmail] = useState("");
//   const [password, setPassword] = useState("");
//   const [repassword, setRepassword] = useState("");
//   const [isMatchPassword, setIsMatchPassword] = useState(true);

//   const onChangeUsername = ({ target }: React.ChangeEvent<HTMLInputElement>) => {
//     setUsername(target.value);
//   };

//   const onChangeEmail = ({ target }: React.ChangeEvent<HTMLInputElement>) => {
//     setEmail(target.value);
//   };

//   const onChangePassword = ({ target }: React.ChangeEvent<HTMLInputElement>) => {
//     setPassword(target.value);
//   };

//   const onChangeRepassword = ({ target }: React.ChangeEvent<HTMLInputElement>) => {
//     const isMatch = password === target.value;
//     setRepassword(target.value);
//     setIsMatchPassword(isMatch);
//   };



//   const join = async () => {
//     const _res = await joinApi({ username, email, password });
//   };

//   const redirectJoinPage = async () => {
//     window.location.href = "/auth/join";
//   };
//   const redirectLoginPage = async () => {
//     window.location.href = "/auth/login";
//   };

//   useEffect(() => {
//     setUsername(EMPTY_STRING);
//     setEmail(EMPTY_STRING);
//     setPassword(EMPTY_STRING);
//     setRepassword(EMPTY_STRING);
//   }, []);

//   return (
//     <Container>
//       <LoginTitle>{type === "signIn" ? "Sign In" : "Sign Up"}</LoginTitle>

//       {type === "signUp" && (
//         <InputContainer>
//           <ImgWrapper>
//             <img src={theme == lightTheme ? emailDark : emailLight}></img>
//           </ImgWrapper>
//           <LoginInput
//             placeholder="E-mail을 입력해주세요."
//             type="email"
//             value={email}
//             onChange={onChangeEmail}
//           ></LoginInput>
//         </InputContainer>
//       )}
//       <InputContainer>
//         <ImgWrapper>
//           <img src={theme == lightTheme ? passwordDark : passwordLight}></img>
//         </ImgWrapper>
//         <LoginInput
//           placeholder="Password을 입력해주세요."
//           type="password"
//           value={password}
//           onChange={onChangePassword}
//         ></LoginInput>
//       </InputContainer>
//       {type === "signUp" && (
//         <InputContainer>
//           <ImgWrapper>
//             <img src={theme == lightTheme ? passwordDark : passwordLight}></img>
//           </ImgWrapper>
//           <LoginInput
//             placeholder="Password을 다시 입력해주세요."
//             type="password"
//             value={repassword}
//             onChange={onChangeRepassword}
//           ></LoginInput>
//         </InputContainer>
//       )}

//       {type === "signUp" && !isMatchPassword && (
//         <ErrorDiv>Password가 일치하지 않습니다.</ErrorDiv>
//       )}

//       <JoinButton onClick={type === "signIn" ? login : join}>
//         {type === "signIn" ? "로그인" : "회원가입"}
//       </JoinButton>
//       <BackButton onClick={type === "signIn" ? redirectJoinPage : redirectLoginPage}>
//         {type === "signIn" ? "회원가입" : "돌아가기"}
//       </BackButton>
//     </Container>
//   );
// }

// const Container = styled.div`
//   display: flex;
//   justify-content: center;
//   align-items: center;
//   flex-direction: column;

//   width: 350px;
//   margin: 100px 0 0 40%;
// `;

// const LoginTitle = styled.div`
//   font-size: 40px;
//   font-weight: 500;

//   color: ${({ theme }) => theme.color.secondary};
// `;


// const ErrorDiv = styled.div`
//   margin: 30px 0px -20px 0px;
//   color: ${({ theme }) => theme.color.red};
// `;

// const JoinButton = styled.button`
//   width: 100%;
//   height: 50px;
//   margin-top: 50px;
//   border-radius: 10px;
//   box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

//   font-size: 18px;

//   color: ${({ theme }) => theme.color.primary};
//   background: ${({ theme }) => theme.color.secondary};
// `;

// const BackButton = styled.button`
//   width: 100%;
//   height: 50px;
//   margin-top: 20px;

//   font-size: 18px;

//   color: ${({ theme }) => theme.color.secondary};
// `;

export const AuthBoxWrapper = styled.div<{width: string}>`
  ${({theme}: ThemeProps<Theme>) => theme.display.flexCenterColumn}

  width: ${({width}) => width};
`