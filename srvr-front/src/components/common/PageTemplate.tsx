import React from "react";
import styled from "styled-components";
import { DefaultHeader } from "./Header";

export const DefaultPageTemplate = ({ children }: any) => {
  return (
    <TemplateContainder>
      <DefaultHeader />
      {children}
    </TemplateContainder>
  );
};

const TemplateContainder = styled.div`
  width: 100%;
  height: 100%;
`;
