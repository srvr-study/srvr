/* eslint-disable react-hooks/exhaustive-deps */
import React, { useContext, useEffect, useState } from "react";
import styled, { ThemeProps } from "styled-components";

import useStompClient from "@/hooks/useStompClient";
import { fetchFeatureServers } from "@apis/mainApiFake";
// import { fetchFeatureServers } from "@apis/mainApi";
import { fetchMeApi } from "@apis/mainApiFake";
// import { fetchMeApi } from "@apis/mainApi";
import FeatureServerBox from "@components/main/FeatureServerBox";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { Theme } from "@constants/theme";
import { FeatureServerType } from "@models/main/FeatureServer";
import { SignInUserType } from "@models/auth/User";
import { I18nContext } from "@providers/I18nProvider";


export default function Main(): JSX.Element {
  const [featureServersMap, setFeatureServersMap] = useState<Map<String, FeatureServerType>>(new Map());
  const [me, setMe] = useState<SignInUserType | null>(null);
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

  function isAdmin() {
    return me && me.role === "admin"; 
  }

  useEffect(() => {
    fetchMeApi().then(apiResponse => {
      const signinUser = apiResponse.result.content;
      signinUser && setMe(signinUser);
    })

    fetchFeatureServers().then((apiResponse) => {
      const featureServers = apiResponse.result.contents;
      renderFeatureServer(featureServers);
    });

    subscribe("/subscribe/feature-servers", (webSocketMessage) => {
      const featureServers = JSON.parse(webSocketMessage.body);
      renderFeatureServer(featureServers);
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
        {isAdmin() && <AddFeatureServerButton />}
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
