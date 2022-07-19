import { HTMLInputTypeAttribute } from "react";
import styled, { ThemeProps } from "styled-components"

import { Theme } from "@constants/theme";


type Props = {
  src: string;
  alt?: string;
  placeholder?: string;
  value: any;
  type?: HTMLInputTypeAttribute;
  onChange?: React.ChangeEventHandler<HTMLInputElement>;
}

export function IconRoundInput({ src, alt, placeholder, value, onChange, type }: Props): JSX.Element {
  return (
    <IconRoundInputWrapper className="icon-round-input">
      <img src={src} alt={alt} />
      <Divider />
      <LoginInput placeholder={placeholder} value={value} onChange={onChange} type={type}/>
    </IconRoundInputWrapper>
  );
};

const IconRoundInputWrapper = styled.div`
  ${({theme}: ThemeProps<Theme>) => theme.display.flexCenter}

  padding: 22px 25px;
  width: 100%;
  border: 1px solid ${({theme}: ThemeProps<Theme>) => theme.color.textPrimary};
  border-radius: 999px;
`

const Divider = styled.span`
  width: 1px;
  height: 28px;
  margin: 0 18px 0 11px;

  background-color: ${({theme}: ThemeProps<Theme>) => theme.color.textPrimary};
`;

const LoginInput = styled.input`
  flex-grow: 1;

  outline: none;
  border: none;

  ${({theme}: ThemeProps<Theme>) => theme.font.build({size: theme.font.size.content.md})}
  color: ${({theme}: ThemeProps<Theme>) => theme.color.textPrimary};
  background: none;

  &::placeholder {
    color: ${({ theme }: ThemeProps<Theme>) => theme.color.placeholder};
  }
`;