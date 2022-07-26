import { HeaderText } from ".";

export type AuthText = {
  headerText: HeaderText,
  signinInText: SignInInText,
  signUpText: SignUpText,
}

type SignInInText = {
  usernamePlaceHolder: string;
  passwordPlaceHolder: string;
  findPasswordMessage: string;
  findPasswordText: string;
  confirmUsernameAndPasswordMessage: string;
  loginText: string;
  joinText: string;
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

export const AuthKR = function (): AuthText {
  const headerText: HeaderText = Object.freeze({
    pageTitle: "Spring JWT Auth",
    headerNavItemDocument: "Document",
    headerNavItemHome: "Home",
  });

  const signinInText: SignInInText = {
    usernamePlaceHolder: "Username을 입력해주세요.",
    passwordPlaceHolder: "Password을 입력해주세요.",
    findPasswordMessage: "비밀번호를 잃어버렸나요?",
    findPasswordText: "비밀번호 찾기",
    confirmUsernameAndPasswordMessage: "Username과 Password을 확인해주세요.",
    loginText: "로그인",
    joinText: "회원가입",
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
