import React, { useContext } from "react";
import styled, { ThemeProps } from "styled-components";
import moon from "@assets/icons/moon-dark.svg";
import sun from "@assets/icons/sun-light.svg";
import { IconButton } from "@components/common/Button";
import { DefaultHeader } from "@components/common/Header";
import { lightTheme, Theme } from "@constants/theme";
import { HeaderText } from "@constants/text";
import { ThemeContext } from "@providers/ThemeProvider";
import { errorKR } from "@constants/text/commonText";

type Props = {
  children: React.ReactNode;
  headerText: HeaderText;
  documentUrl: string;
};

export function DefaultPageTemplate({
  children,
  headerText,
  documentUrl
}: Props): JSX.Element {
  const { theme, themeDispatch } = useContext(ThemeContext);

  const changeTheme = () => {
    if (!themeDispatch) {
      throw new Error(errorKR.failedToSetTheme);
    }
    if (theme === lightTheme) {
      themeDispatch({ type: "SET_DARK_THEME" });
    } else {
      themeDispatch({ type: "SET_LIGHT_THEME" });
    }
  };

  return (
    <TemplateContainer>
      <DefaultHeader headerText={headerText} documentUrl={documentUrl} />
      <ContentContainer>
        {children}
      </ContentContainer>
      <FloatingContainer>
        <IconButton
          src={theme === lightTheme ? moon : sun}
          onClick={changeTheme}
        />
      </FloatingContainer>
    </TemplateContainer>
  );
}

const TemplateContainer = styled.div`
  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenterColumn}

  width: 100%;
  min-height: 100%;

  background: ${({ theme }: ThemeProps<Theme>) => theme.color.background};

  transition: 0.5s;
`;

const ContentContainer = styled.div`
  display: flex;
  flex-grow: 1;

  width: 100%;
`

const FloatingContainer = styled.div`
  position: fixed;
  bottom: 60px;
  right: 60px;

  & > button {
    ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenter}

    width: 60px;
    height: 60px;
    border-radius: 50%;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

    background: ${({ theme }: ThemeProps<Theme>) => theme.color.foreground};

    transition: 0.5s;
  }
`;

export const ContentTitle = styled.h1`
margin-bottom: 45px;

${({ theme }: ThemeProps<Theme>) => theme.font.build({ size: theme.font.size.title.xlg })}
color: ${({ theme }: ThemeProps<Theme>) => theme.color.textPrimary};
`;
