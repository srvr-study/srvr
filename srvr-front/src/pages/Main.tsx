import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { fetchFeatureServers } from "../apis/mainApiFake";
import { DefaultPageTemplate } from "../components/common/PageTemplate";
import FeatureServerBox, {
  FeatureServer,
} from "../components/main/FeatureServerBox";

export default function Main(): JSX.Element {
  const [featureServers, setFeatuerServers] = useState<
    Map<String, FeatureServer>
  >(new Map());

  useEffect(() => {
    fetchFeatureServers().then((response: any) => {
      const data = response.data;
      setFeatuerServers((prev) => {
        const newState = new Map(prev);
        data.forEach((featureServer: FeatureServer) => {
          newState.set(featureServer.name, featureServer);
        });
        return newState;
      });
    });
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
