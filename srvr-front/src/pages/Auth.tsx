/* eslint-disable react-hooks/exhaustive-deps */
import React from "react";
import styled from "styled-components";
// import { fetchFeatureServers } from "@apis/mainApiFake";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { authTextKR } from "@constants/text";

export default function AuthMain(): JSX.Element {
  return (
    <DefaultPageTemplate title={authTextKR.MainPageTitle}>
      <FeatureServerWrapper></FeatureServerWrapper>
    </DefaultPageTemplate>
  );
}

const FeatureServerWrapper = styled.div`
  display: flex;
  width: 100%;
  min-height: calc(100% - 90px);
  padding: 55px 20px 0 45px;

  flex-wrap: wrap;
`;
