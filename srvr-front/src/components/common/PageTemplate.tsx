import React, { useContext } from "react";
import styled from "styled-components";
import { lightTheme } from "../../constants/theme";
import { IconButton } from "./Button";
import { DefaultHeader } from "./Header";
import sun from "../../assets/icons/sun-light.svg";
import moon from "../../assets/icons/moon-dark.svg";
import { ThemeContext } from "../../providers/ThemeProvider";

export const DefaultPageTemplate = ({ children }: any) => {
  const { theme, themeDispatch } = useContext(ThemeContext);

  const changeTheme = () => {
    if (theme === lightTheme) {
      themeDispatch({ type: "SET_DARK_THEME" });
    } else {
      themeDispatch({ type: "SET_LIGHT_THEME" });
    }
  };

  return (
    <TemplateContainder>
      <DefaultHeader />
      {children}
      <FloatingContainer>
        <IconButton
          src={theme === lightTheme ? moon : sun}
          onClick={changeTheme}
        />
      </FloatingContainer>
    </TemplateContainder>
  );
};

const TemplateContainder = styled.div`
  width: 100%;
  height: 100%;

  background: ${({ theme }) => theme.color.background};

  transition: 0.5s;
`;

const FloatingContainer = styled.div`
  position: fixed;
  bottom: 60px;
  right: 60px;

  & > button {
    ${({ theme }) => theme.display.flexCenter}

    width: 60px;
    height: 60px;
    border-radius: 50%;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

    background: ${({ theme }) => theme.color.primary};

    transition: 0.5s;
  }
`;
