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

export const MainKR = function () {
  const headerText: HeaderText = Object.freeze({
    pageTitle: "스프링 포트폴리오 프로젝트",
    headerNavItemDocument: "Document",
    headerNavItemHome: "Home",
  });

  type MainText = {
    featureServerBoxIsNotActive: string;
    featureServerBoxNeedAuth: string;
  };

  const featureServerText: MainText = Object.freeze({
    featureServerBoxIsNotActive: "개발 중 입니다.",
    featureServerBoxNeedAuth: "인증이 선행되어야 합니다.",
  });

  return {
    headerText: headerText,
    featureServerText: featureServerText,
  }
}();

export const AuthKR = function () {
  const headerText: HeaderText = Object.freeze({
    pageTitle: "Spring JWT Auth",
    headerNavItemDocument: "Document",
    headerNavItemHome: "Home",
  });

  type SignInInText = {
    usernamePlaceHolder: string;
    passwordPlaceHolder: string;
    findPasswordMessage: string;
    findPasswordText: string;
    confirmUsernameAndPasswordMessage: string;
    loginText: string;
    joinText: string;
  }

  const signinInText: SignInInText = {
    usernamePlaceHolder: "Username을 입력해주세요.",
    passwordPlaceHolder: "Password을 입력해주세요.",
    findPasswordMessage: "비밀번호를 잃어버렸나요?",
    findPasswordText: "비밀번호 찾기",
    confirmUsernameAndPasswordMessage: "Username과 Password을 확인해주세요.",
    loginText: "로그인",
    joinText: "회원가입",
  }

  type SignUpText = {
    usernamePlaceHolder: string;
    emailPlaceHolder: string;
    passwordPlaceHolder: string;
    repasswordPlaceHodler: string;
    joinText: string;
    backText: string;
    siteCautionMessage: string;
  }

  const signUpText: SignUpText = {
    usernamePlaceHolder: "Username을 입력해주세요.",
    emailPlaceHolder: "E - mail을 입력해주세요.",
    passwordPlaceHolder: "Password을 입력해주세요.",
    repasswordPlaceHodler: "Password을 다시 입력해주세요.",
    joinText: "회원가입",
    backText: "돌아가기",
    siteCautionMessage: "공부용 웹 사이트로 사용자의 개인정보를 보호 하지 않는 사이트입니다. 회원가입 주의바랍니다.",
  }

  return {
    headerText: headerText,
    signinInText: signinInText,
    signUpText: signUpText,
  }
}();
