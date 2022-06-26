import styled from "styled-components";

type Props = {
  src: string;
  alt?: string;
  placeholder?: string;
  value?: any;
  onChange?: React.ChangeEventHandler<HTMLInputElement>;
};

export function IconRoundInput({
  src,
  alt,
  placeholder,
  value,
  onChange,
}: Props): JSX.Element {
  return (
    <IconRoundInputWrapper>
      <img src={src} alt={alt} />
      <p></p>
      <input
        placeholder={placeholder}
        value={value}
        onChange={onChange}
      ></input>
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

  & > p {
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
