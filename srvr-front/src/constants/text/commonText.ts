export type ErrorMessage = {
  failedToSetTheme: string;
  failedToSetI18n: string;
};

export const errorKR: ErrorMessage = Object.freeze({
  failedToSetTheme: "테마 변경을 실패했습니다.",
  failedToSetI18n: "언어 변경에 실패했습니다.",
});

export const errorEN: ErrorMessage = Object.freeze({
  failedToSetTheme: "Failed to set theme.",
  failedToSetI18n: "Failed to set language.",
});
