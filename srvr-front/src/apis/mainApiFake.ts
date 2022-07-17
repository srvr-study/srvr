export const fetchFeatureServers = () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        result: {
          contents: [
            {
              name: "Spring JWT Auth Server",
              isActive: true,
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
            },
            {
              name: "Spring JWT Auth Server2",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server3",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server4",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server5",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server6",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server7",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server8",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server9",
              isActive: true,
              path: "/auth/login",
            },
            {
              name: "Spring JWT Auth Server10",
              isActive: true,
              path: "/auth/login",
            },
          ]
        },
      });
    }, 1000);
  });
};
