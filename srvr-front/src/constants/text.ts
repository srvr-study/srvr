type CommonText = {
  MainPageTitle: string;
  HeaderNavItemDocument: string;
  HeaderNavItemHome: string;
};

export const commonTextKR: CommonText = Object.freeze({
  MainPageTitle: "스프링 포트폴리오 프로젝트",
  HeaderNavItemDocument: "Document",
  HeaderNavItemHome: "Home",
});

interface AuthText extends CommonText {
  UsernamePlaceholder: string;
  PasswordPlaceholder: string;
  FindPasswordMessage: string;
  FindPasswordText: string;
  ErrorMessage: string;
  LoginText: string;
  SignUpText: string;
}

export const authTextKR: AuthText = {
  ...commonTextKR,
  MainPageTitle: "스프링 JWT Auth",
  UsernamePlaceholder: "Username을 입력해주세요.",
  PasswordPlaceholder: "Password을 입력해주세요.",
  FindPasswordMessage: "비밀번호를 잃어버렸나요?",
  FindPasswordText: "비밀번호 찾기",
  ErrorMessage: "Username과 Password을 확인해주세요.",
  LoginText: "로그인",
  SignUpText: "회원가입",
};

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
