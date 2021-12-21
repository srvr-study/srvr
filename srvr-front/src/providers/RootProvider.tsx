import React from "react";
import ThemeProvider from "./ThemeProvider";

const RootProvider = ({ children }: any) => {
  return <ThemeProvider>{children}</ThemeProvider>;
};

export default RootProvider;
