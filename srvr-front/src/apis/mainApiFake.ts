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
          ]
        },
      });
    }, 1000);
  });
};
