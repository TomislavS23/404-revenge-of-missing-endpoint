import {Navigate, Outlet} from "react-router";
import {getAccessToken, getRefreshToken} from "../../ts/storage/SessionStorage.tsx";
import {getUserRole} from "../../ts/storage/Authentication.tsx";

const ProtectedRoute = ({requiredRole}: { requiredRole: string }) => {

    if (!getAccessToken() && !getRefreshToken()) {
        return <Navigate to="/login" replace/>;
    }

    if (requiredRole) {
        const userRole = getUserRole();
        if (userRole[0] !== requiredRole) {
            return <Navigate to={"/"} replace/>;
        }
    }

    return <Outlet/>;
};

export default ProtectedRoute;