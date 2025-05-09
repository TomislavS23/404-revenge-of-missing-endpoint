import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import '../styles/general/index.css'
import {BrowserRouter} from "react-router";
import AppRoutes from "../routes/AppRoutes.tsx";
import Sidebar from "./Sidebar.tsx";

createRoot(document.getElementById('root')!).render(
    <BrowserRouter>
        <StrictMode>
            <Sidebar/>
            <AppRoutes/>
        </StrictMode>
    </BrowserRouter>
)
