import {Route, Routes} from "react-router";
import ProtectedRoute from "./ProtectedRoute.tsx";
import Sidebar from "../components/Sidebar.tsx";

export default function AppRoutes() {
    return (
        <>
            <Routes>
                <Route element={<ProtectedRoute requiredRole={"ROLE_user"}/>}>
                    <Route path={'/dashboard'} element={<Sidebar/>}/>
                    <Route path={'/xml'} element={<Sidebar/>}/>
                    <Route path={'/soap'} element={<Sidebar/>}/>
                    <Route path={'/xml/rpc'} element={<Sidebar/>}/>
                    <Route path={'/crud'} element={<Sidebar/>}/>
                </Route>
            </Routes>
        </>
    )
}