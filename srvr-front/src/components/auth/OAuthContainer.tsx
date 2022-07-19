import { Theme } from "@constants/theme";
import styled, { ThemeProps } from "styled-components";
import { OAuthElement, OAuthElementProp } from "./OAuthElement";


export function OAuthContainer(): JSX.Element {
  const elements: OAuthElementProp[] = [{providerName: "github"}];

  return (
    <OAuthContainerWrapper>
      {elements.map(element => <OAuthElement key={element.providerName} element={element} />)}
    </OAuthContainerWrapper>
  );
}

const OAuthContainerWrapper = styled.ul`

  margin-top: 68px;

  ${({theme}: ThemeProps<Theme>) => theme.display.flexCenter}
`;