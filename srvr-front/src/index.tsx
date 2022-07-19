import React from "react";
import ReactDOM from "react-dom";
import { Route, Routes } from "react-router";
import { BrowserRouter } from "react-router-dom";
import "@/index.css";

import reportWebVitals from "@/reportWebVitals";
import RootProvider from "@providers/RootProvider";
import Main from "@pages/Main";
import Auth from "@pages/Auth";

import { SignInBox } from "@components/auth/SignInBox";
import { SignUpBox } from "@components/auth/SignUpBox";
import { FindPasswordBox } from "@components/auth/FindPasswordBox";
import { ResetPasswordBox } from "@components/auth/ResetPasswordBox";
import { SuccessSignInBox } from "@components/auth/SuccessSignInBox";


ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <RootProvider>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/auth/*" element={<Auth />} >
            <Route path="login" element={<SignInBox />} />
            <Route path="join" element={<SignUpBox />} />
            <Route path="find-password" element={<FindPasswordBox />} />
            <Route path="reset-password" element={<ResetPasswordBox />} />
            <Route path="success" element={<SuccessSignInBox />} />
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
