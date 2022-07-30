/* eslint-disable react-hooks/exhaustive-deps */
import React, { useContext, useEffect, useState } from "react";
import styled, { ThemeProps } from "styled-components";

import useStompClient from "@/hooks/useStompClient";
import { fetchFeatureServers } from "@apis/mainApiFake";
// import { fetchFeatureServers } from "@apis/mainApi";
import FeatureServerBox, { FeatureServerType} from "@components/main/FeatureServerBox";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { Theme } from "@constants/theme";
import { I18nContext } from "@providers/I18nProvider";


export default function Main(): JSX.Element {
  const [featureServersMap, setFeatureServersMap] = useState<
    Map<String, FeatureServerType>
  >(new Map());
  const mainText = useContext(I18nContext).i18n.main;
  const { subscribe } = useStompClient();

  function renderFeatureServer(data: any) {
    setFeatureServersMap((prev) => {
      const newState = new Map(prev);
      data.forEach((featureServer: FeatureServerType) => {
        newState.set(featureServer.name, featureServer);
      });
      return newState;
    });
  }

  useEffect(() => {
    fetchFeatureServers().then((body: any) => {
      const data = body.result.contents;
      renderFeatureServer(data);
    });

    subscribe("/subscribe/feature-servers", (featureServers) => {
      const data = JSON.parse(featureServers.body);
      console.log(data)
      renderFeatureServer(data)
    });
  }, []);

  return (
    <DefaultPageTemplate headerText={mainText.headerText} documentUrl="/document">
      <FeatureServerWrapper>
        {Array.from(featureServersMap.values()).map((featureServer) => (
          <FeatureServerBox
            key={featureServer.name}
            title={featureServer.name}
            isActive={featureServer.isActive}
            isNeedAuth={featureServer.isNeedAuth}
            path={featureServer.path}
          />
        ))}
      </FeatureServerWrapper>
    </DefaultPageTemplate>
  );
}

const FeatureServerWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  align-content: baseline;
  
  width: 100%;
  padding: 55px 20px 0 45px;

  background: ${({ theme }: ThemeProps<Theme>) => theme.color.subground};

  transition: 0.5s;
`;
