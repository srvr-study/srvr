import React, { useContext } from "react";
import styled, { css, ThemeProps } from "styled-components";

import { Theme } from "@constants/theme";
import { I18nContext } from "@providers/I18nProvider";




type Props = {
  title: string;
  isActive: boolean;
  isNeedAuth: boolean;
  path: string;
};

export default function FeatureServerBox({
  title,
  isActive,
  isNeedAuth = false,
  path,
}: Props): JSX.Element {
  const mainText = useContext(I18nContext).i18n.main;

  return (
    <FeatureServerBoxContainer
      isActive={isActive}
      disabled={!isActive}
      onClick={() => (window.location.href = path)}
    >
      <Title>{title}</Title>
      {!isActive && (
        <NonActive>{mainText.featureServerText.featureServerBoxIsNotActive}</NonActive>
      )}
      {isNeedAuth && <NeedAuth>{mainText.featureServerText.featureServerBoxNeedAuth}</NeedAuth>}
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
