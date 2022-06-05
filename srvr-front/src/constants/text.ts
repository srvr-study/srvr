export type HeaderText = {
  PageTitle: string;
  HeaderNavItemDocument: string;
  HeaderNavItemHome: string;
};

export const commonTextKR: HeaderText = Object.freeze({
  PageTitle: "스프링 포트폴리오 프로젝트",
  HeaderNavItemDocument: "Document",
  HeaderNavItemHome: "Home",
});

export const authTextKR: HeaderText = Object.freeze({
  PageTitle: "Spring JWT Auth",
  HeaderNavItemDocument: "Document",
  HeaderNavItemHome: "Home",
});

type MainText = {
  FeatureServerBoxIsNotActive: string;
  FeatureServerBoxNeedAuth: string;
};

export const mainTextKR: MainText = Object.freeze({
  FeatureServerBoxIsNotActive: "개발 중 입니다.",
  FeatureServerBoxNeedAuth: "인증이 선행되어야 합니다.",
});

type Error = {
  FailedToSetTheme: string;
};

export const errorKR: Error = Object.freeze({
  FailedToSetTheme: "테마 변경을 실패했습니다.",
});
