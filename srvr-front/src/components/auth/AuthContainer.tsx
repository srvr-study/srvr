
import { Theme } from "@constants/theme"
import styled, { ThemeProps } from "styled-components"


// export function AuthContainer({ type }: Props): JSX.Element {
//   const [isMatchPassword, setIsMatchPassword] = useState(true);

//   const onChangeRepassword = ({ target }: React.ChangeEvent<HTMLInputElement>) => {
//     const isMatch = password === target.value;
//     setRepassword(target.value);
//     setIsMatchPassword(isMatch);
//   };

export const AuthBoxWrapper = styled.div<{ width: string }>`
  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenterColumn}

  width: ${({ width }) => width};
`