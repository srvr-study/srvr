export const fetchFeatureServers = () => {
    return fetch("http://localhost:8080/api/v1/feature-servers").then((response) => {
        return response.json()
    })
  };
  