import { makeMainUrl, _get } from "./baseApi";

export const fetchFeatureServersApi = () => _get(makeMainUrl("api/v1/feature-servers"));