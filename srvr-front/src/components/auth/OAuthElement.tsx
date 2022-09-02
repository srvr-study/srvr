import { Theme } from "@constants/theme";
import styled, { ThemeProps } from "styled-components";

type Props = {
  element: OAuthElementProp;
}

export interface OAuthElementProp {
  providerName: string;
}

export function OAuthElement({ element }: Props): JSX.Element {
  return (
    <OAuthElementWrapper>
      <img src="" alt=""/>
    </OAuthElementWrapper>
  );
}

const OAuthElementWrapper = styled.li`
  width: 60px;
  height: 60px;
  border-radius: 50%;

  background: ${({theme}: ThemeProps<Theme>) => theme.color.darkGray};
`;