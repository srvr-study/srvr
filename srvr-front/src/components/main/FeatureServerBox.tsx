import React from "react";
import styled, { css } from "styled-components";

export type FeatureServer = {
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

const FeatureServerBox = ({ title, isActive, isNeedAuth = false }: Props) => {
  return (
    <FeatureServerBoxContainer
      onClick={() => console.log("heello")}
      isActive={isActive}
      disabled={!isActive}
    >
      {!isActive && <NonActive>개발 중 입니다.</NonActive>}
      <Title>{title}</Title>
      {isNeedAuth && <NeedAuth>인증이 선행되어야 합니다.</NeedAuth>}
    </FeatureServerBoxContainer>
  );
};

export default FeatureServerBox;

const FeatureServerBoxContainer = styled.button<{ isActive: Boolean }>`
  position: relative;

  ${({ theme }) => theme.display.flexCenterColumn}

  width: 200px;
  height: 200px;
  border-radius: 10px;
  margin: 0 30px 30px 0;
  box-shadow: 0px 4px 4px 2px rgba(0, 0, 0, 0.25);

  background: ${({ theme }) => theme.color.primary};

  transition: 0.5s;

  &:hover {
    transform: translateY(-5px);
    box-shadow: 0px 6px 8px 4px rgba(0, 0, 0, 0.15);
  }

  ${({ isActive }) =>
    !isActive &&
    css`
      opacity: 0.5;

      &:hover {
        transform: none;
        box-shadow: 0px 4px 4px 2px rgba(0, 0, 0, 0.25);
        cursor: not-allowed;
      }
    `};

  & > span {
    text-align: center;
  }
`;

const NonActive = styled.span`
  ${({ theme }) => theme.font.build({ weight: 700, size: theme.font.size.sm })}

  color: ${({ theme }) => theme.color.placeholder};
`;

const Title = styled.span`
  margin: 10px 0;
  ${({ theme }) => theme.font.build({ size: theme.font.size.lg })}

  color: ${({ theme }) => theme.color.secondary};
`;

const NeedAuth = styled.span`
  ${({ theme }) => theme.font.build({ size: theme.font.size.xsm })}

  color: ${({ theme }) => theme.color.red};
`;
