
import { Theme } from "@constants/theme"
import styled, { ThemeProps } from "styled-components"

export const AuthBoxWrapper = styled.div<{ width: string }>`
  ${({ theme }: ThemeProps<Theme>) => theme.display.flexCenterColumn}

  width: ${({ width }) => width};
`