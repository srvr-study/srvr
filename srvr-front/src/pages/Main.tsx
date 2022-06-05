/* eslint-disable react-hooks/exhaustive-deps */
import React, { useEffect, useState } from "react";
import styled from "styled-components";
// import { fetchFeatureServers } from "@apis/mainApiFake";
import { fetchFeatureServers } from "@apis/mainApi";
import FeatureServerBox, {
  FeatureServerType,
} from "@components/main/FeatureServerBox";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import useStompClient from "@/hooks/useStompClient";

export default function Main(): JSX.Element {
  const [featureServersMap, setFeatureServersMap] = useState<
    Map<String, FeatureServerType>
  >(new Map());

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
      const data = body.result.contents
      renderFeatureServer(data);
    });

    subscribe("/subscribe/feature-servers", (featureServers) => {
      const data = JSON.parse(featureServers.body);
      console.log(data)
      renderFeatureServer(data)
    })
  }, []);

  return (
    <DefaultPageTemplate>
      <FeatureServerWrapper>
        {Array.from(featureServersMap.values()).map((featureServer) => (
          <FeatureServerBox
            key={featureServer.name}
            title={featureServer.name}
            isActive={featureServer.isActive}
            isNeedAuth={featureServer.isNeedAuth}
          />
        ))}
      </FeatureServerWrapper>
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
