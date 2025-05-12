import {Route, Routes} from "react-router";
import ProtectedRoute from "./ProtectedRoute.tsx";
import Login from "../auth/Login.tsx";
import Home from "../Home.tsx";
import Xml from "../operations/Xml.tsx";
import Soap from "../operations/Soap.tsx";
import Rpc from "../operations/Rpc.tsx";
import Database from "../operations/Database.tsx";

export default function AppRoutes() {
    return (
        <>
            <Routes>
                <Route element={<ProtectedRoute requiredRole={"ROLE_user"}/>}>
                    <Route path={'/dashboard'} element={<Home/>}/>
                    <Route path={'/xml'} element={<Xml/>}/>
                    <Route path={'/soap'} element={<Soap/>}/>
                    <Route path={'/xml/rpc'} element={<Rpc/>}/>
                    <Route path={'/database'} element={<Database/>}/>
                </Route>
                <Route path={'/login'} element={<Login/>}/>
                <Route path={'/'} element={<Login/>}/>
            </Routes>
        </>
    )
}