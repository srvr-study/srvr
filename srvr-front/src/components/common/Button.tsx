import React, { MouseEventHandler } from "react";
import styled, { css } from "styled-components";

type Props = {
  src?: string;
  alt?: string;
  onClick?: MouseEventHandler;
  title?: string;
};

export const IconButton = ({ src, onClick, alt, title }: Props) => {
  return (
    <IconButtonWrapper onClick={onClick} title={title}>
      <img src={src} alt={alt} />
    </IconButtonWrapper>
  );
};

const IconButtonWrapper = styled.button<{ title?: string }>`
  position: relative;

  ${({ theme }) => theme.display.flexCenterColumn}

  ${({ title }) =>
    title &&
    css`
      & > img {
        position: relative;
        transform: translateY(0px);
        transition: 0.3s;
      }

      &:hover > img {
        transform: translateY(-10px);
      }

      &:after {
        position: absolute;
        bottom: 0;
        transform: translateY(0px);
        transition: 0.3s;

        content: "${title}";

        ${({ theme }) =>
          theme.font.build({ weight: 700, size: theme.font.size.xsm })}

        color: ${({ theme }) => theme.color.secondary};

        opacity: 0;
      }

      &:hover:after {
        transform: translateY(10px);
        opacity: 1;
      }
    `}
`;
