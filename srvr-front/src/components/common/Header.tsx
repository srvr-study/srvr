import styled from "styled-components";
import { CommonTextKR } from "../../constants/text";
import { IconButton } from "./Button";
import home from "../../assets/icons/home.svg";

export const DefaultHeader = () => {
  return (
    <HeaderContainer>
      <PageTitle>{CommonTextKR.PageTitle}</PageTitle>
      <NavButton>{CommonTextKR.Document}</NavButton>
      <IconButton src={home} />
    </HeaderContainer>
  );
};

const HeaderContainer = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;

  width: 100%;
  height: 90px;
  padding: 0 30px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.12);
`;

const PageTitle = styled.h2`
  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: normal;
  font-size: 30px;
  line-height: 41px;

  color: #262626;
`;

const NavButton = styled.button`
  margin-left: auto;
  margin-right: 26px;

  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: normal;
  font-size: 30px;
  line-height: 41px;
`;
