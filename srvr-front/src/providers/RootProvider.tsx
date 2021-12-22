import React from "react";
import ThemeProvider from "@providers/ThemeProvider";

type Props = {
  children: React.ReactNode;
};

export default function RootProvider({ children }: Props): JSX.Element {
  return <ThemeProvider>{children}</ThemeProvider>;
}
