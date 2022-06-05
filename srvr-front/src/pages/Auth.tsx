import { useContext, useEffect } from "react";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { authTextKR, errorKR } from "@constants/text";
import { ThemeContext } from "@providers/ThemeProvider";
import { AuthContainer } from "@components/auth/AuthContainer";

export default function Auth(): JSX.Element {
  const { theme, themeDispatch } = useContext(ThemeContext);

  useEffect(() => {
    if (!themeDispatch) {
      throw new Error(errorKR.FailedToSetTheme);
    }
    themeDispatch({ type: "SET_LIGHT_THEME" });
  }, []);

  return (
    <DefaultPageTemplate headerText={authTextKR}>
      {window.location.pathname === "/auth/login" ? (
        <AuthContainer type="signIn" />
      ) : (
        <AuthContainer type="signUp" />
      )}
    </DefaultPageTemplate>
  );
}
