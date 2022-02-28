type FontProps = {
  family: string;
  style: string;
  weight: string;
  size: string;
};

type Color = {
  primary: string;
  secondary: string;
  background: string;
  white: string;
  placeholder: string;
  text: string;
};

export type Theme = {
  font: {
    family: {
      kr: string;
    };
    size: {
      xlg: string;
      lg: string;
      md: string;
      sm: string;
      xsm: string;
    };
    build: ({ family, style, weight, size }: FontProps) => string;
  };
  color: Color;
  display: any;
};

const pixelToRem = (size: number) => `${size / 16}rem`;

const fontBuild = ({
  family = fontFamilies.kr,
  style = "normal",
  weight = "normal",
  size = fontSizes.md,
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
  xlg: pixelToRem(30),
  lg: pixelToRem(26),
  md: pixelToRem(22),
  sm: pixelToRem(18),
  xsm: pixelToRem(16),
};

const lightColors = {
  primary: "#ffffff",
  secondary: "#2D333B",
  background: "#F4F4F4",
  white: "#ffffff",
  placeholder: "#7E7E7E",
  text: "#252525",
  red: "#DB2323",
};

const darkColors = {
  primary: "#2D333B",
  secondary: "#ffffff",
  background: "#22272E",
  white: "#ffffff",
  placeholder: "#7E7E7E",
  text: "#252525",
  red: "#DB2323",
};

const display = {
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
