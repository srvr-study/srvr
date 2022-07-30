import { HeaderText } from ".";

export type MainText = {
  headerText: HeaderText;
  featureServerText: FeatureServerText;
}

type FeatureServerText = {
  featureServerBoxIsNotActive: string;
  featureServerBoxNeedAuth: string;
};

export const MainKR = function (): MainText {
  const headerText: HeaderText = Object.freeze({
    pageTitle: "스프링 포트폴리오 프로젝트",
    headerNavItemDocument: "Document",
    headerNavItemHome: "Home",
  });

  const featureServerText: FeatureServerText = Object.freeze({
    featureServerBoxIsNotActive: "개발 중 입니다.",
    featureServerBoxNeedAuth: "인증이 선행되어야 합니다.",
  });

  return {
    headerText: headerText,
    featureServerText: featureServerText,
  }
}();

export const MainEN = function (): MainText {
  const headerText: HeaderText = Object.freeze({
    pageTitle: "Spring Portfolio Project",
    headerNavItemDocument: "Document",
    headerNavItemHome: "Home",
  });

  const featureServerText: FeatureServerText = Object.freeze({
    featureServerBoxIsNotActive: "Developing...",
    featureServerBoxNeedAuth: "Authentication must be first.",
  });

  return {
    headerText: headerText,
    featureServerText: featureServerText,
  }
}();
