import { makeMainUrl, _post } from "./baseApi";

type LoginRequest = {
  username: string;
  password: string;
};

interface JoinRequest extends LoginRequest {
  email: string;
  role: string;
}

type FindPasswordRequest = {
  email: string;
  code: string;
}

// todo 비밀번호 찾기, 코드 검증, 로그아웃 api 연결
export const joinApi = (joinRequest: JoinRequest) => _post(makeMainUrl("/api/v1/user/join"), { body: JSON.stringify(joinRequest) });
export const checkUsernameApi = (username : string) => _post(makeMainUrl(`/api/v1/user/${username}/check`));
export const loginApi = (loginRequest: LoginRequest) => _post(makeMainUrl("/api/v1/user/login"), { body: JSON.stringify(loginRequest) });
export const requestVerificationCodeMail = (email: string) => _post(makeMainUrl(`/api/v1/user/${email}/password-code`));
export const checkVerifiactionCode = (FindPasswordRequest: FindPasswordRequest) => _post(makeMainUrl("/api/v1/user/password-code-check"), { body: JSON.stringify(FindPasswordRequest) });
