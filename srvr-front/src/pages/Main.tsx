import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { fetchFeatureServers } from "@apis/mainApiFake";
import FeatureServerBox, {
  FeatureServerType,
} from "@components/main/FeatureServerBox";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import useStompClient from "@/hooks/useStompClient";

export default function Main(): JSX.Element {
  const [featureServers, setFeatuerServers] = useState<
    Map<String, FeatureServerType>
  >(new Map());

  const { subscribe } = useStompClient();

  useEffect(() => {
    fetchFeatureServers().then((response: any) => {
      const data = response.data;
      setFeatuerServers((prev) => {
        const newState = new Map(prev);
        data.forEach((featureServer: FeatureServerType) => {
          newState.set(featureServer.name, featureServer);
        });
        return newState;
      });
    });

    subscribe("/subscribe/feature-servers", (server) => {
      console.log(server);
    })
  }, []);

  return (
    <DefaultPageTemplate>
      <FeatureServerWrapper>
        {Array.from(featureServers.values()).map((featureServer) => (
          <FeatureServerBox
            key={featureServer.name}
            title={featureServer.title}
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
