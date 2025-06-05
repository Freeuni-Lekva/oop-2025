import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import {GoogleOAuthProvider} from "@react-oauth/google";

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);
root.render(
    <React.StrictMode>
        <GoogleOAuthProvider clientId={"167422372012-rkrht884bjuqeq2d1u80rudffruhmg74.apps.googleusercontent.com"}>
            <App/>
        </GoogleOAuthProvider>
    </React.StrictMode>
);

