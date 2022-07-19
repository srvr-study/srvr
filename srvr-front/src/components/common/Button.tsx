import { Theme } from "@constants/theme";
import React, { MouseEventHandler } from "react";
import styled, { css, ThemeProps } from "styled-components";

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

  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenterColumn}

  ${({ title }) => title && css`
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

        ${({ theme }: ThemeProps<Theme>) => theme.font.build({ weight: "700", size: theme.font.size.content.xsm })}

        color: ${({ theme }: ThemeProps<Theme>) => theme.color.secondary};

        opacity: 0;
      }

      &:hover:after {
        transform: translateY(10px);
        opacity: 1;
      }
    `}
`;

type TextBoxButtonProps = {
  width: string;
  text: string;
  onClick?: MouseEventHandler;
}

export function TextBoxButton({width, text, onClick}: TextBoxButtonProps):JSX.Element {
  return (
  <TextBoxButtonWarpper width={width} onClick={onClick} className="text-box-button">
    {text}
  </TextBoxButtonWarpper>
  );
};

const TextBoxButtonWarpper = styled.button<{width: string}>`
  ${({theme}:ThemeProps<Theme>) => theme.display.flexCenter}

  width: ${({width}) => width};
  padding: 20px;
  border-radius: 10px;

  background: ${({theme}:ThemeProps<Theme>) => theme.color.primary};
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.4));

  ${({theme}:ThemeProps<Theme>) => theme.font.build({size: theme.font.size.content.lg})}
  color: ${({theme}:ThemeProps<Theme>) => theme.color.textSecondary};

  transition: 0.3s;

  &:hover {
    transform: scale(1.01);

    filter: drop-shadow(0px 6px 6px rgba(0, 0, 0, 0.25));
  }
`

type TextButtonProps = {
  text: string;
  onClick?: MouseEventHandler;
}


export function TextButton({text, onClick}:TextButtonProps): JSX.Element {
  return <TextButtonWrapper onClick={onClick}>{text}</TextButtonWrapper>;
}

const TextButtonWrapper = styled.button`
  border: none;

  background-color: ${({theme}:ThemeProps<Theme>) => theme.color.background};

  ${({theme}: ThemeProps<Theme>) => theme.font.build({size: theme.font.size.content.md})}
`
