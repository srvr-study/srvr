import React from "react";

export const IconButton = ({ src, onClick }: any) => {
  return (
    <button onClick={onClick}>
      <img src={src} />
    </button>
  );
};
