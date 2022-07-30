import { makeMainUrl, _post } from "./baseApi";

type LoginRequest = {
  username: string;
  password: string;
};

interface JoinRequest extends LoginRequest {
  email: string;
  role: string;
}

export const loginApi = (loginRequest: LoginRequest) => _post(makeMainUrl("/api/v1/user/login"), { body: JSON.stringify(loginRequest) });
export const joinApi = (joinRequest: JoinRequest) => _post(makeMainUrl("/api/v1/user/join"), { body: JSON.stringify(joinRequest) });
