import { Outlet } from "react-router-dom";
import styled from "styled-components";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { authTextKR } from "@constants/text";

export default function Auth(): JSX.Element {

  return (
    <DefaultPageTemplate headerText={authTextKR}>
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
