const mainUrl = process.env.REACT_APP_SRVR_MAIN_SERVER_HOST;
const authUrl = process.env.REACT_APP_SRVR_AUTH_SERVER_HOST;

type ApiUrl = string;
export const makeMainUrl = (path: string): ApiUrl => mainUrl + path;
export const makeAuthUrl = (path: string): ApiUrl => authUrl + path;

type ApiResponse<T> = {
  header: ApiHeader;
  result: ApiContent<T>;
}

type ApiHeader = {
  isSuccessful: boolean;
  message?: string;
  code?: number;
}

type ApiContent<T> = {
  content?: T;
  contents?: T[];
  totalCount?: number;
}

const getJson = <T>(response: Response): Promise<ApiResponse<T>> => response.json();

const getDefaultOption = (method: string, option?: RequestInit): RequestInit => {
  return {
    method: method,
    headers: {
      'Content-Type': 'application/json',
    },
    ...option
  }
}

export const _get = <T>(apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("GET", option)).then(response => getJson<T>(response));
export const _post = <T>(apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("POST", option)).then(response => getJson<T>(response));
export const _delete = <T>(apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("DELETE", option)).then(response => getJson<T>(response));
export const _put = <T>(apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("PUT", option)).then(response => getJson<T>(response));
export const _patch = <T>(apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("PATCH", option)).then(response => getJson<T>(response));
