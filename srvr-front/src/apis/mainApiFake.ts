export const fetchFeatureServers = () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        result: {
          contents:  [
            {
              name: "Spring JWT Auth Server",
              isActive: true,
            },
            {
              name: "Spring Chatting Server",
              isActive: false,
              isNeedAuth: true,
            },
          ]
        },
      });
    }, 1000);
  });
};
