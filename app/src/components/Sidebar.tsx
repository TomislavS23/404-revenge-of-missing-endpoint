import '../styles/ui/sidebar.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import {Link} from "react-router";
import 'material-icons/iconfont/material-icons.css'
import '../styles/material/material.css'

export default function Sidebar() {
    return (
        <>
            <div className="sidebar d-flex flex-column p-2">
                <div className="mt-1 ms-2">
                    <p className={"text-tertiary fs-3 fw-bold unselectable"}>404:RME</p>
                </div>
                <div className="mt-3">
                    <Link className="sidebar-link" to="/dashboard">
                        <div className="d-flex align-items-center fw-bold">
                            <span className="material-icons me-2">home</span>
                            Home
                        </div>
                    </Link>
                    <div className="accordion py-2" id="accordionExample" data-bs-theme={"dark"}>
                        <div className="accordion-item">
                            <h2 className="accordion-header">
                                <button className="accordion-button" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <div className="d-flex align-items-center fw-bold">
                                        <span className="material-icons me-2">data_object</span>
                                        Operations
                                    </div>
                                </button>
                            </h2>
                            <div id="collapseOne" className="accordion-collapse collapse my-2"
                                 data-bs-parent="#accordionExample">
                                <Link className="sidebar-link py-2 px-3" to="/xml">
                                    <div className="d-flex align-items-center">
                                        <span className="material-icons material-icons-small me-2">check_circle</span>
                                        XML Validation
                                    </div>
                                </Link>
                                <Link className="sidebar-link py-2 px-3" to="/soap">
                                    <div className="d-flex align-items-center">
                                        <span className="material-icons material-icons-small me-2">api</span>
                                        SOAP
                                    </div>
                                </Link>
                                <Link className="sidebar-link py-2 px-3" to="/xml/rpc">
                                    <div className="d-flex align-items-center">
                                        <span className="material-icons material-icons-small me-2">api</span>
                                        XML-RPC
                                    </div>
                                </Link>
                                <Link className="sidebar-link py-2 px-3" to="/crud">
                                    <div className="d-flex align-items-center">
                                        <span className="material-icons material-icons-small me-2">storage</span>
                                        Database
                                    </div>
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}