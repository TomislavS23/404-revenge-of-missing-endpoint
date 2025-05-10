import {Route, Routes} from "react-router";
import ProtectedRoute from "./ProtectedRoute.tsx";
import Login from "../auth/Login.tsx";
import Dashboard from "../Dashboard.tsx";

export default function AppRoutes() {
    return (
        <>
            <Routes>
                <Route element={<ProtectedRoute requiredRole={"ROLE_user"}/>}>
                    <Route path={'/dashboard'} element={<Dashboard/>}/>
                </Route>
                <Route path={'/login'} element={<Login/>}/>
                <Route path={'/'} element={<Login/>}/>
            </Routes>
        </>
    )
}