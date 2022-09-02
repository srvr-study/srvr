import React from "react";
import I18nProvider from "@providers/I18nProvider";
import ThemeProvider from "@providers/ThemeProvider";


type Props = {
  children: React.ReactNode;
};

export default function RootProvider({ children }: Props): JSX.Element {
  return (
    <I18nProvider>
      <ThemeProvider>
        {children}
      </ThemeProvider>
    </I18nProvider>
  );
}
