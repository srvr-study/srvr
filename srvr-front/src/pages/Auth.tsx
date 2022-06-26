/* eslint-disable react-hooks/exhaustive-deps */
import React from "react";
import styled from "styled-components";
// import { fetchFeatureServers } from "@apis/mainApiFake";
import { DefaultPageTemplate } from "@components/common/PageTemplate";
import { authTextKR } from "@constants/text";
import {
  CenterMiddleWrapper,
  FlexFullWrapper,
} from "@components/common/Wrapper";
import { IconRoundInput } from "@components/common/Input";
import userFill from "@assets/icons/user-fill.svg";
import key from "@assets/icons/key.svg";
import OAuthProviders from "@components/auth/OAuthProviders";
import { TextButton, TextButtonBox } from "@components/common/Button";

export default function AuthMain(): JSX.Element {
  return (
    <DefaultPageTemplate title={authTextKR.MainPageTitle}>
      <FlexFullWrapper>
        <CenterMiddleWrapper>
          <LoginWrapper>
            <ContentTitle>Sign In</ContentTitle>
            <IconRoundInput
              src={userFill}
              placeholder={authTextKR.UsernamePlaceholder}
            />
            <IconRoundInput
              src={key}
              type={"password"}
              placeholder={authTextKR.PasswordPlaceholder}
            />
            <Message className="findPasswordMessage">
              {authTextKR.FindPasswordMessage}
              <span>{authTextKR.FindPasswordText}</span>
            </Message>
            <RedMessage>{authTextKR.ErrorMessage}</RedMessage>
            <OAuthProviders />
            <TextButtonBox
              width="460px"
              height="77px"
              text={authTextKR.LoginText}
            />
            <TextButton text={authTextKR.SignUpText} />
          </LoginWrapper>
        </CenterMiddleWrapper>
      </FlexFullWrapper>
    </DefaultPageTemplate>
  );
}

const LoginWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  width: 460px;
  margin-bottom: 100px;

  & > div:nth-of-type(1) {
    margin-bottom: 31px;
  }

  & > .textButtonBox {
    margin-bottom: 19px;
  }

  & > .textButton:hover {
    text-decoration: underline;
  }

  & > .findPasswordMessage {
    margin-bottom: 15px;
  }
`;

const ContentTitle = styled.h2`
  margin-bottom: 57px;

  ${({ theme }) => theme.font.build({ size: theme.font.size.title })}
`;

const Message = styled.p`
  width: 100%;
  margin-top: 18px;
`;
const RedMessage = styled.p`
  width: 100%;

  color: ${({ theme }) => theme.color.red};
`;
