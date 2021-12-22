import React from "react";
import ThemeProvider from "./ThemeProvider";

type Props = {
  children: React.ReactNode;
};

export default function RootProvider({ children }: Props): JSX.Element {
  return <ThemeProvider>{children}</ThemeProvider>;
}
