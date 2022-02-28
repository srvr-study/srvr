import React from "react";
import { render, screen } from "@testing-library/react";
import Main from "./Main";

test("메인 페이지 렌더링 테스트", () => {
  render(<Main />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
