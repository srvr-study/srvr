import React, { useContext } from "react";
import styled from "styled-components";
import moon from "@assets/icons/moon-dark.svg";
import sun from "@assets/icons/sun-light.svg";
import { IconButton } from "@components/common/Button";
import { DefaultHeader } from "@components/common/Header";
import { errorKR } from "@constants/text";
import { lightTheme } from "@constants/theme";
import { ThemeContext } from "@providers/ThemeProvider";

type Props = {
  title: string;
  children: React.ReactNode;
};

export function DefaultPageTemplate({ title, children }: Props): JSX.Element {
  const { theme, themeDispatch } = useContext(ThemeContext);

  const changeTheme = () => {
    if (!themeDispatch) {
      throw new Error(errorKR.FailedToSetTheme);
    }
    if (theme === lightTheme) {
      themeDispatch({ type: "SET_DARK_THEME" });
    } else {
      themeDispatch({ type: "SET_LIGHT_THEME" });
    }
  };

  return (
    <TemplateContainder>
      <DefaultHeader title={title} />
      {children}
      <FloatingContainer>
        <IconButton
          src={theme === lightTheme ? moon : sun}
          onClick={changeTheme}
        />
      </FloatingContainer>
    </TemplateContainder>
  );
}

const TemplateContainder = styled.div`
  display: flex;
  flex-direction: column;

  width: 100%;
  min-height: 100%;

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
