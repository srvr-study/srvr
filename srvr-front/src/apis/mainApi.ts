import { SignInUserType } from "@models/auth/User";
import { FeatureServerType } from "@models/main/FeatureServer";
import { makeMainUrl, _get } from "./baseApi";

export const fetchMeApi = () => _get<SignInUserType>(makeMainUrl("/api/v1/user/me"));
export const fetchFeatureServersApi = () => _get<FeatureServerType>(makeMainUrl("api/v1/feature-servers"));