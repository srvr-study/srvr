const baseUrl = process.env.REACT_APP_SRVR_MAIN_SERVER_HOST;

const url = (path: string): string => baseUrl + path;
const getJson = (response: Response): Promise<any> => response.json();

export const fetchFeatureServers = () => {
    return fetch(url("api/v1/feature-servers")).then(getJson)
};
