import { Outlet } from "react-router-dom";
import styled from "styled-components";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { AuthKR } from "@constants/text";

export default function Auth(): JSX.Element {

  return (
    <DefaultPageTemplate headerText={AuthKR.headerText}>
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
