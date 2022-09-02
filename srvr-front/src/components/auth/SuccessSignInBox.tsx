import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import { AuthBoxWrapper } from "./AuthContainer";

import { TextBoxButton, TextButton } from "@components/common/Button";
import { ContentTitle } from "@components/common/PageTemplate";
import { useEffect } from "react";
import { fetchMeApi } from "@apis/mainApi";


export function SuccessSignInBox(): JSX.Element {
  const navigate = useNavigate();

  useEffect(() => {
    fetchMeApi().then((data) => {
      console.log(data);
    });
  }, []);

  return (
    <SuccessSignInBoxWrapper width={"460px"}>
      <ContentTitle>Success Sign In</ContentTitle>
      
      <TextBoxButton text={"Home 이동"} width={"460px"} onClick={() => navigate("/")} />
      <TextButton text={"로그아웃"} onClick={() => navigate("/auth/login")} />
    </SuccessSignInBoxWrapper>
  );
}

const SuccessSignInBoxWrapper = styled(AuthBoxWrapper)`
  & .icon-round-input {
    margin-bottom: 30px;

    :last-child {
      margin-bottom: 0px;
    }
  }

  & .text-box-button {
    margin: 19px 0;

    &:first-child {
      margin-top: 31px;
    }
  }
`;
