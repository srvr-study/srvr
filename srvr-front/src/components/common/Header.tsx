import React, { useContext } from "react";
import styled, { ThemeProps } from "styled-components";
import documentDark from "@assets/icons/document-dark.svg";
import documentLight from "@assets/icons/document-light.svg";
import homeDark from "@assets/icons/home-dark.svg";
import homeLight from "@assets/icons/home-light.svg";
import { IconButton } from "@components/common/Button";
import { lightTheme, Theme } from "@constants/theme";
import { HeaderText } from "@constants/text";
import { ThemeContext } from "@providers/ThemeProvider";
import { useNavigate } from "react-router-dom";

type HeaderProps = {
  headerText: HeaderText;
  documentUrl: string;
}

export function DefaultHeader({headerText, documentUrl}: HeaderProps): JSX.Element {
  const { theme } = useContext(ThemeContext);
  const navigate = useNavigate();

  return (
    <HeaderContainer>
      <PageTitle>{headerText.pageTitle}</PageTitle>
      <FlexRightWrapper>
        <IconButton
          src={theme === lightTheme ? documentDark : documentLight}
          title={headerText.headerNavItemDocument}
          onClick={() => navigate(documentUrl)}
        />
        <IconButton
          src={theme === lightTheme ? homeDark : homeLight}
          title={headerText.headerNavItemHome}
          onClick={() => navigate("/")}
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
