import React, { MouseEventHandler } from "react";

type Props = {
  src?: string;
  alt?: string;
  onClick?: MouseEventHandler;
};

export const IconButton = ({ src, onClick, alt }: Props) => {
  return (
    <button onClick={onClick}>
      <img src={src} alt={alt} />
    </button>
  );
};
