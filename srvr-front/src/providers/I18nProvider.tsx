import React, { createContext, useReducer } from "react";
import { ThemeProvider as StyledThemeProvider } from "styled-components";
import { errorKR } from "@constants/text";
import { darkTheme, lightTheme, Theme } from "@constants/theme";

type Props = {
  children: React.ReactNode;
};

// export default function I18nProvider({ children }: Props): JSX.Element {
//   const [i18n, i18nDispatch] = useReducer<
//     (state: I18n, action: I18nAction) => Theme
//   >(reducer, lightTheme);

//   return (
//     <ThemeContext.Provider value={{ theme, themeDispatch }}>
//       <StyledThemeProvider theme={theme}>{children}</StyledThemeProvider>
//     </ThemeContext.Provider>
//   );
// }

// type I18nAction = {
//   type: string;
// };

// const reducer = (_: I18n, action: I18nAction) => {
//   switch (action.type) {
//     case "SET_LIGHT_THEME":
//       return lightTheme;
//     case "SET_DARK_THEME":
//       return darkTheme;
//     default:
//       throw new Error(errorKR.failedToSetTheme);
//   }
// };

// type ThemeContextType = {
//   theme: Theme;
//   themeDispatch?: React.Dispatch<any>;
// };

// export const I18nProvider = createContext<ThemeContextType>({
//   theme: lightTheme,
// });
