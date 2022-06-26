import React, { MouseEventHandler } from "react";
import styled, { css } from "styled-components";

type Props = {
  src: string;
  alt?: string;
  onClick?: MouseEventHandler;
  title?: string;
};

export function IconButton({ src, onClick, alt, title }: Props): JSX.Element {
  return (
    <IconButtonWrapper onClick={onClick} title={title}>
      <img src={src} alt={alt} />
    </IconButtonWrapper>
  );
}

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

type TextButtonProps = {
  text: string;
  onClick?: MouseEventHandler;
};

interface TextButtonBoxProps extends TextButtonProps {
  width: string;
  height: string;
}

export function TextButtonBox({
  text,
  onClick,
  width,
  height,
}: TextButtonBoxProps): JSX.Element {
  return (
    <TextButtonBoxWrapper
      className="textButtonBox"
      onClick={onClick}
      width={width}
      height={height}
    >
      {text}
    </TextButtonBoxWrapper>
  );
}

const TextButtonBoxWrapper = styled.button<{ width: string; height: string }>`
  display: flex;
  align-items: center;
  justify-content: center;

  border-radius: 10px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  background-color: ${({ theme }) => theme.color.secondary};

  ${({ theme }) => theme.font.build({ size: theme.font.size.lg })}
  color: ${({ theme }) => theme.color.primary};

  ${({ width, height }) =>
    css`
      width: ${width};
      height: ${height};
    `}
`;

export function TextButton({ text, onClick }: TextButtonProps): JSX.Element {
  return (
    <TextButtonWrapper className="textButton" onClick={onClick}>
      {text}
    </TextButtonWrapper>
  );
}

const TextButtonWrapper = styled.button`
  outline: none;

  background: none;

  ${({ theme }) => theme.font.build({ size: theme.font.size.sm })}
  color: ${({ theme }) => theme.color.secondary};
`;
