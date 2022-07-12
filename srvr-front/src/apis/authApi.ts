const baseUrl = process.env.REACT_APP_SRVR_AUTH_SERVER_HOST;
type loginInfo = {
  username: string;
  password: string;
};

type joinInfo = loginInfo & {
  email: string;
};

export const loginApi = async ({ username, password }: loginInfo) => {
  const _res = await fetch(
    "http://localhost:8080/api/v1/user/login",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        password,
      }),
    }
  );
  const res = await _res.json();
  console.log(res);
};

export const joinApi = async ({
  username,
  email,
  password
}: joinInfo) => {
  const _res = await fetch(
    "http://localhost:8080/api/v1/user/join",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        email,
        password
      }),
    }
  );
};
