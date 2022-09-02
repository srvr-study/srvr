import { useNavigate } from "react-router-dom";
import styled, { ThemeProps } from "styled-components";

import { AuthBoxWrapper } from "./AuthContainer";

import { TextBoxButton, TextButton } from "@components/common/Button";
import { ContentTitle } from "@components/common/PageTemplate";
import { Theme } from "@constants/theme";


export function ResetPasswordBox(): JSX.Element {
  const navigate = useNavigate();

  return (
    <ResetPasswordBoxWrapper width={"460px"}>
      <ContentTitle>Success Sign In</ContentTitle>
      <LoginUserText><p>로그인한 유저 : </p><p>유저 네임</p></LoginUserText>
      <TextBoxButton text={"Home 이동"} width={"460px"} onClick={() => navigate("/")} />
      <TextButton text={"로그아웃"} onClick={() => { }} />
    </ResetPasswordBoxWrapper>
  );
}

const ResetPasswordBoxWrapper = styled(AuthBoxWrapper)`
  & .text-box-button {
    margin: 19px 0;

    &:first-child {
      margin-top: 31px;
    }
  }
`;

const LoginUserText = styled.div`
  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenter}

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.lg })}
`
