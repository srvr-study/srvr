import { useContext, useEffect } from "react";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { authTextKR, errorKR } from "@constants/text";
import { ThemeContext } from "@providers/ThemeProvider";
import { AuthContainer } from "@components/auth/AuthContainer";
import styled, {ThemeProps} from "styled-components";
import {Theme} from "@constants/theme";

export default function Auth(): JSX.Element {

  return (
    <DefaultPageTemplate headerText={authTextKR}>
      <AuthWrapper>
      {window.location.pathname === "/auth/login" ? (
        <AuthContainer type="signIn" />
      ) : (
        <AuthContainer type="signUp" />
      )}
      </AuthWrapper>
    </DefaultPageTemplate>
  );
}

const AuthWrapper = styled.div`
  display: flex;
  flex-grow: 1;

  background: ${({ theme }: ThemeProps<Theme>) => theme.color.subground};

  transition: 0.5s;
`;
