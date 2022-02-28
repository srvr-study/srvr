export const fetchFeatureServers = () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        data: [
          {
            name: "Spring_JWT_Auth_Server",
            title: "Spring JWT Auth Server",
            isActive: true,
          },
          {
            name: "Spring_Chatting_Server",
            title: "Spring Chatting Server",
            isActive: false,
            isNeedAuth: true,
          },
        ],
      });
    }, 1000);
  });
};
