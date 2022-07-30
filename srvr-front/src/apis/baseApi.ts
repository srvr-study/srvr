const mainUrl = process.env.REACT_APP_SRVR_MAIN_SERVER_HOST;
const authUrl = process.env.REACT_APP_SRVR_AUTH_SERVER_HOST;

type ApiUrl = string;
export const makeMainUrl = (path: string): ApiUrl => mainUrl + path;
export const makeAuthUrl = (path: string): ApiUrl => authUrl + path;

const getJson = (response: Response): Promise<any> => response.json();

const getDefaultOption = (method: string, option?: RequestInit): RequestInit => {
  return {
    method: method,
    headers: {
      'Content-Type': 'application/json',
    },
    ...option
  }
}

export const _get = (apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("GET", option)).then(getJson);
export const _post = (apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("POST", option)).then(getJson);
export const _delete = (apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("DELETE", option)).then(getJson);
export const _put = (apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("PUT", option)).then(getJson);
export const _patch = (apiUrl: ApiUrl, option?: RequestInit) => fetch(apiUrl, getDefaultOption("PATCH", option)).then(getJson);
