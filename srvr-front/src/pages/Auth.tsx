import { useContext } from "react";
import { Outlet } from "react-router-dom";
import styled from "styled-components";

import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { I18nContext } from "@providers/I18nProvider";


export default function Auth(): JSX.Element {
  const authText = useContext(I18nContext).i18n.auth;
  
  return (
    <DefaultPageTemplate headerText={authText.headerText} documentUrl="/auth/document">
      <AuthWrapper>
        <Outlet />
      </AuthWrapper>
    </DefaultPageTemplate>
  );
};

const AuthWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100%;
`;
