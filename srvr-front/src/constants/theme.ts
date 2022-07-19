type FontProps = {
  family?: string;
  style?: string;
  weight?: string;
  size?: string;
};

type CommonColor = {
  red: string;
  gray: string;
  darkGray: string;
}

interface Color extends CommonColor {
  background: string;
  subground: string;
  foreground: string;
  dimmed: string;
  primary: string;
  secondary: string;
  textPrimary: string;
  textSecondary: string;
  placeholder: string;
  border: string;
}

type Size = {
  xlg: string;
  lg: string;
  md: string;
  sm: string;
  xsm?: string;
}

type Display = {
  flexCenter: string,
  flexCenterColumn: string
}

export type Theme = {
  font: {
    family: {
      kr: string;
    };
    size: {
      title: Size,
      content: Size,
    };
    build: ({ family, style, weight, size }: FontProps) => string;
  };
  color: Color;
  display: Display;
};

const pixelToRem = (size: number) => `${size / 16}rem`;

const fontBuild = ({
  family = fontFamilies.kr,
  style = "normal",
  weight = "normal",
  size = fontSizes.content.md,
}: FontProps) => {
  return `
    font-family: ${family};
    font-style: ${style};
    font-weight: ${weight};
    font-size: ${size};
  `;
};

const fontFamilies = {
  kr: "Noto Sans KR",
};

const fontSizes = {
  title: {
    xlg: pixelToRem(60),
    lg: pixelToRem(48),
    md: pixelToRem(40),
    sm: pixelToRem(32),
  },
  content: {
    xlg: pixelToRem(30),
    lg: pixelToRem(26),
    md: pixelToRem(22),
    sm: pixelToRem(18),
    xsm: pixelToRem(16),
  }
};

const commonColor = {
  red: "#DB2323",
  gray: "#F4F4F4",
  darkGray: "#C4C4C4"
}

const lightColors: Color = {
  ...commonColor,
  background: "#FFFFFF",
  subground: "#F4F4F4",
  foreground: "#FFFFFF",
  dimmed: "X",
  primary: "#2D333B",
  secondary: "X",
  textPrimary: "#000000",
  textSecondary: "#FFFFFF",
  placeholder: "#7E7E7E",
  border: "#909090"
};

const darkColors: Color = {
  ...commonColor,
  background: "#22272E",
  subground: "#22272E",
  foreground: "#2D333B",
  dimmed: "X",
  primary: "#2753EE",
  secondary: "#FFFFFF",
  textPrimary: "#FFFFFF",
  textSecondary: "#FFFFFF",
  placeholder: "#7E7E7E",
  border: "#22272E",
};

export const display = {
  flexCenter: `
    display: flex;
    justify-content: center;
    align-items: center;
  `,
  flexCenterColumn: `
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  `,
};

function createTheme(colorsType: Color): Theme {
  return {
    font: {
      family: fontFamilies,
      size: fontSizes,
      build: fontBuild,
    },
    color: colorsType,
    display,
  };
}

export const lightTheme: Theme = createTheme(lightColors);
export const darkTheme: Theme = createTheme(darkColors);
