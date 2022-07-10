import React from "react";
import styled, { css, ThemeProps } from "styled-components";
import { mainTextKR } from "@constants/text";
import { Theme } from "@constants/theme";

export type FeatureServerType = {
  name: string;
  title: string;
  isActive: boolean;
  isNeedAuth: boolean;
};

type Props = {
  title: string;
  isActive: boolean;
  isNeedAuth: boolean;
};

export default function FeatureServerBox({
  title,
  isActive,
  isNeedAuth = false,
}: Props): JSX.Element {
  return (
    <FeatureServerBoxContainer isActive={isActive} disabled={!isActive}>
      <Title>{title}</Title>
      {!isActive && (
        <NonActive>{mainTextKR.FeatureServerBoxIsNotActive}</NonActive>
      )}
      {isNeedAuth && <NeedAuth>{mainTextKR.FeatureServerBoxNeedAuth}</NeedAuth>}
    </FeatureServerBoxContainer>
  );
}

const FeatureServerBoxContainer = styled.button<{ isActive: Boolean }>`
  position: relative;

  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenterColumn}

  width: 200px;
  height: 200px;
  border-radius: 10px;
  margin: 0 30px 30px 0;
  box-shadow: 0px 4px 4px 2px rgba(0, 0, 0, 0.25);

  background: ${({ theme }: ThemeProps<Theme>) => theme.color.foreground};

  transition: 0.5s;

  &:hover {
    box-shadow: 0px 6px 8px 4px rgba(0, 0, 0, 0.15);

    transform: translateY(-5px);
  }

  ${({ isActive }) => !isActive && css`
      opacity: 0.5;

      &:hover {
        box-shadow: 0px 4px 4px 2px rgba(0, 0, 0, 0.25);

        transform: none;
        cursor: not-allowed;
      }
    `};

  & > span {
    text-align: center;
  }
`;

const NonActive = styled.span`
  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ weight: "700", size: theme.font.size.content.sm })}

  color: ${({ theme }: ThemeProps<Theme>) => theme.color.placeholder};
`;

const Title = styled.span`
  margin: 10px 0;

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.lg })}

  color: ${({ theme }: ThemeProps<Theme>) => theme.color.secondary};
`;

const NeedAuth = styled.span`
  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.xsm })}

  color: ${({ theme }: ThemeProps<Theme>) => theme.color.red};
`;
