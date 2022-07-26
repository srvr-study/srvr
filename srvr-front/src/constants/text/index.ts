import { AuthText } from "./authText";
import { MainText } from "./mainText";

export type I18n = {
  main: MainText;
  auth: AuthText;
}

export type HeaderText = {
  pageTitle: string;
  headerNavItemDocument: string;
  headerNavItemHome: string;
};

type Error = {
  failedToSetTheme: string;
};

export const errorKR: Error = Object.freeze({
  failedToSetTheme: "테마 변경을 실패했습니다.",
});