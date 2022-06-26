import styled from "styled-components";

type Props = {
  src: string;
  type?: React.HTMLInputTypeAttribute;
  alt?: string;
  placeholder?: string;
  value?: any;
  onChange?: React.ChangeEventHandler<HTMLInputElement>;
};

export function IconRoundInput({
  src,
  type,
  alt,
  placeholder,
  value,
  onChange,
}: Props): JSX.Element {
  return (
    <IconRoundInputWrapper>
      <img src={src} alt={alt} />
      <span></span>
      <input
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        type={type}
      />
    </IconRoundInputWrapper>
  );
}

const IconRoundInputWrapper = styled.div`
  display: flex;
  align-items: center;
  width: 460px;
  padding: 24px;
  border: 1px solid ${({ theme }) => theme.color.secondary};
  border-radius: 999px;

  & > span {
    height: 24px;
    margin: 0 18px 0 11px;
    border-right: 1px solid ${({ theme }) => theme.color.secondary};
  }

  & > input {
    flex-grow: 1;
    background: none;
    border: none;

    ${({ theme }) => theme.font.build({ size: theme.font.size.md })}
  }

  & > input:focus {
    outline: none;
  }
`;
