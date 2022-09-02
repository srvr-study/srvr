import { AuthEN, AuthKR, AuthText } from "./authText";
import { errorEN, errorKR, ErrorMessage } from "./commonText";
import { MainEN, MainKR, MainText } from "./mainText";

export type I18n = {
  main: MainText;
  auth: AuthText;
  error: ErrorMessage;
}

export type HeaderText = {
  pageTitle: string;
  headerNavItemDocument: string;
  headerNavItemHome: string;
};

export const KO_KR: I18n = Object.freeze({
  main: MainKR,
  auth: AuthKR,
  error: errorKR
});

export const EN: I18n = Object.freeze({
  main: MainEN,
  auth: AuthEN,
  error: errorEN
});
