import React from "react";
import ReactDOM from "react-dom";
import { Route, Routes } from "react-router";
import { BrowserRouter } from "react-router-dom";
import "@/index.css";

import reportWebVitals from "@/reportWebVitals";
import RootProvider from "@providers/RootProvider";
import Auth from "@pages/Auth";
import Main from "@pages/Main";
import { SignInBox } from "@components/auth/SignInBox";
import { SignUpBox } from "@components/auth/SignUpBox";


ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <RootProvider>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route  path="/auth/*" element={<Auth />} >
            <Route path="login" element={<SignInBox />} />
            <Route path="join" element={<SignUpBox />} />
          </Route>
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
