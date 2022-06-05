type loginInfo = {
  username: string;
  password: string;
};

type joinInfo = loginInfo & {
  email: string;
  repassword: string;
};

export const loginApi = async ({ username, password }: loginInfo) => {
  const _res = await fetch(
    "http://localhost:8081/feature-servers/auth/v1/login",
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
  password,
  repassword,
}: joinInfo) => {
  const _res = await fetch(
    "http://localhost:8081/feature-servers/auth/v1/join",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        email,
        password,
        repassword,
      }),
    }
  );
};
