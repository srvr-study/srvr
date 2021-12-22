import React, { createContext, useReducer } from "react";
import { ThemeProvider as StyledThemeProvider } from "styled-components";
import { errorKR } from "../constants/text";
import { darkTheme, lightTheme, Theme } from "../constants/theme";

type Props = {
  children: React.ReactNode;
};

export default function ThemeProvider({ children }: Props): JSX.Element {
  const [theme, themeDispatch] = useReducer<
    (state: Theme, action: ThemeAction) => Theme
  >(reducer, lightTheme);

  return (
    <ThemeContext.Provider value={{ theme, themeDispatch }}>
      <StyledThemeProvider theme={theme}>{children}</StyledThemeProvider>
    </ThemeContext.Provider>
  );
}

type ThemeAction = {
  type: string;
};

const reducer = (_: Theme, action: ThemeAction) => {
  switch (action.type) {
    case "SET_LIGHT_THEME":
      return lightTheme;
    case "SET_DARK_THEME":
      return darkTheme;
    default:
      throw new Error(errorKR.FailedToSetTheme);
  }
};

type ThemeContextType = {
  theme: Theme;
  themeDispatch?: React.Dispatch<any>;
};

export const ThemeContext = createContext<ThemeContextType>({
  theme: lightTheme,
});
