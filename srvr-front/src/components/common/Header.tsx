import React, { useContext } from "react";
import styled, { ThemeProps } from "styled-components";
import documentDark from "@assets/icons/document-dark.svg";
import documentLight from "@assets/icons/document-light.svg";
import homeDark from "@assets/icons/home-dark.svg";
import homeLight from "@assets/icons/home-light.svg";
import { IconButton } from "@components/common/Button";
import { commonTextKR } from "@constants/text";
import { lightTheme, Theme } from "@constants/theme";
import { ThemeContext } from "@providers/ThemeProvider";

export function DefaultHeader(): JSX.Element {
  const { theme } = useContext(ThemeContext);

  return (
    <HeaderContainer>
      <PageTitle>{commonTextKR.MainPageTitle}</PageTitle>
      <FlexRightWrapper>
        <IconButton
          src={theme === lightTheme ? documentDark : documentLight}
          title={commonTextKR.HeaderNavItemDocument}
        />
        <IconButton
          src={theme === lightTheme ? homeDark : homeLight}
          title={commonTextKR.HeaderNavItemHome}
        />
      </FlexRightWrapper>
    </HeaderContainer>
  );
}

const HeaderContainer = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;

  width: 100%;
  height: 90px;
  padding: 0 30px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.12);

  background: ${({ theme }: ThemeProps<Theme>) => theme.color.foreground};
  z-index: 100;

  transition: 0.5s;

  & button:first-of-type {
    margin-right: 30px;
  }
`;

const PageTitle = styled.h2`
  height: 30px;

  ${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.content.lg })}

  color: ${({ theme }: ThemeProps<Theme>) => theme.color.secondary};
`;

const FlexRightWrapper = styled.div`
  display: flex;

  margin-left: auto;
`;
