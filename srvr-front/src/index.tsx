import React from "react";
import ReactDOM from "react-dom";
import { Route, Routes } from "react-router";
import { BrowserRouter } from "react-router-dom";
import "@/index.css";
import reportWebVitals from "@/reportWebVitals";
import Main from "@pages/Main";
import RootProvider from "@providers/RootProvider";

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <RootProvider>
        <Routes>
          <Route path="/" element={<Main />} />
        </Routes>
      </RootProvider>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals(console.log);
