import React, { createContext, useReducer } from "react";
import { ThemeProvider as StyledThemeProvider } from "styled-components";
import { errorKR } from "../constants/text";
import { darkTheme, lightTheme, Theme } from "../constants/theme";

const initialState: any = {};

const reducer = (_: any, action: any) => {
  switch (action.type) {
    case "SET_LIGHT_THEME":
      return lightTheme;
    case "SET_DARK_THEME":
      return darkTheme;
    default:
      throw new Error(errorKR.FailedToSetTheme);
  }
};

const ThemeProvider = ({ children }: any) => {
  const [theme, themeDispatch] = useReducer<(state: any, action: any) => Theme>(
    reducer,
    lightTheme
  );
  return (
    <ThemeContext.Provider value={{ theme, themeDispatch }}>
      <StyledThemeProvider theme={theme}>{children}</StyledThemeProvider>
    </ThemeContext.Provider>
  );
};

export const ThemeContext = createContext(initialState);

export default ThemeProvider;
