import * as React from "react";
import {useNavigate} from "react-router";
import {login} from "../../ts/storage/Authentication.tsx";

export default function Login() {
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const username = document.getElementById("username") as HTMLInputElement;
        const password = document.getElementById("password") as HTMLInputElement;

        try {
            await login(username.value, password.value);
            navigate("/dashboard");
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <>
            <div className='container d-flex align-items-center justify-content-center'>
                <div className="card w-50" data-bs-theme="dark">
                    <div className="card-header">
                        LOGIN
                    </div>
                    <div className="card-body">
                        <form onSubmit={handleSubmit}>
                            <div className="mb-3">
                                <label className="form-label">Username</label>
                                <input type="text" className="form-control" id="username"
                                       aria-describedby="emailHelp" required/>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Password</label>
                                <input type="password" className="form-control" id="password" required/>
                            </div>
                            <div className="col-12 mt-5">
                                <p className="text-danger" hidden={true} id={"login-warning"}>Username or email already
                                    exists!</p>
                                <button className="btn btn-primary" type="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}