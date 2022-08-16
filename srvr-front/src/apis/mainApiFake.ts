import { SignInUserType } from "@models/auth/User";
import { FeatureServerType } from "@models/main/FeatureServer";

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

export const fetchMeApi: () => Promise<ApiResponse<SignInUserType>> = () => {
  return new Promise<ApiResponse<SignInUserType>>((resolve) => {
    setTimeout(() => {
      const value: ApiResponse<SignInUserType> = {
        header: {
          isSuccessful: true,
        },
        result: {
          content: {
            username: "Alencion",
            email: "rhqnrdl625@gmail.com",
            role: "admin",
          }
        }
      }
      resolve(value);
    }, 1000);
  });
};

export const fetchFeatureServers: () => Promise<ApiResponse<FeatureServerType>> = () => {
  return new Promise<ApiResponse<FeatureServerType>>((resolve) => {
    setTimeout(() => {
      const value: ApiResponse<FeatureServerType> = {
        header: {
          isSuccessful: true
        },
        result: {
          contents: [
            {
              name: "Spring JWT Auth Server",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
            {
              name: "Spring Chatting Server",
              isActive: false,
              isNeedAuth: true,
              path: "/chatting",
            },
            {
              name: "Spring JWT Auth Server1",
              isActive: true,
              path: "/auth/login",
              isNeedAuth: false,
            },
            {
              name: "Spring JWT Auth Server2",
              isActive: true,
              path: "/auth/login",
              isNeedAuth: false,
            },
            {
              name: "Spring JWT Auth Server3",
              isActive: true,
              path: "/auth/login",
              isNeedAuth: false,
            },
            {
              name: "Spring JWT Auth Server4",
              isActive: true,
              path: "/auth/login",
              isNeedAuth: false,
            },
            {
              name: "Spring JWT Auth Server5",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server6",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server7",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server8",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server9",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server10",
              isActive: true,
              isNeedAuth: false,
              path: "/auth/login",
            },
          ]
        }
      }

      resolve(value);
    }, 1000);
  });
};
