import React, { MouseEventHandler } from "react";
import styled from "styled-components";

type ChildrenProps = {
  onClick?: MouseEventHandler;
  children: React.ReactNode;
};

export function FlexFullWrapper({
  children,
  onClick,
}: ChildrenProps): JSX.Element {
  return <Full onClick={onClick}>{children}</Full>;
}
const Full = styled.div`
  display: flex;
  flex-grow: 1;

  width: 100%;
  height: 100%;

  background: ${({ theme }) => theme.color.background};
`;

export function CenterMiddleWrapper({
  children,
  onClick,
}: ChildrenProps): JSX.Element {
  return <CenterMiddle onClick={onClick}>{children}</CenterMiddle>;
}

const CenterMiddle = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  width: 100%;
`;
