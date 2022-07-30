import React, { createContext, useReducer } from "react";
import { EN, I18n, KO_KR } from "@constants/text";
import { errorKR } from "@constants/text/commonText";

type Props = {
  children: React.ReactNode;
};

export default function I18nProvider({ children }: Props): JSX.Element {
  const [i18n, i18nDispatch] = useReducer<
    (state: I18n, action: I18nAction) => I18n
  >(reducer, getLocale(navigator.language));

  function getLocale(locale: string) {
    if(locale.includes("ko")) {
      return KO_KR;
    }
    if(locale.includes("en")){
      return EN;
    }
    return KO_KR;
  }

  return (
    <I18nContext.Provider value={{ i18n, i18nDispatch }}>
      {children}
    </I18nContext.Provider>
  );
}

type I18nAction = {
  type: string;
};

const reducer = (_: I18n, action: I18nAction): I18n => {
  switch (action.type) {
    case "SET_DEFAULT":
      console.log("SET language ko!");
      return KO_KR;
    case "SET_KR":
      console.log("SET language ko!");
      return KO_KR;
    case "SET_EN":
      console.log("SET language en!");
      return EN;
    default:
      throw new Error(errorKR.failedToSetTheme);
  }
};

type I18nContextType = {
  i18n: I18n;
  i18nDispatch?: React.Dispatch<any>;
};

export const I18nContext = createContext<I18nContextType>({
  i18n: KO_KR,
});
