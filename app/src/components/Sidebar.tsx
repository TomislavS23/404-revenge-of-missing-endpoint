import '../styles/ui/sidebar.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import {Link} from "react-router";

export default function Sidebar() {
    return (
        <>
            <div className="sidebar d-flex flex-column p-2">
                <div className="mt-1 ms-2">
                    <p className={"text-tertiary fs-3 fw-bold unselectable"}>404:RME</p>
                </div>
                <div className="mt-3">
                    <Link className="sidebar-link" to="/dashboard">
                        HOME
                    </Link>
                    <div className="accordion py-2" id="accordionExample" data-bs-theme={"dark"}>
                        <div className="accordion-item">
                            <h2 className="accordion-header">
                                <button className="accordion-button" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Operations
                                </button>
                            </h2>
                            <div id="collapseOne" className="accordion-collapse collapse my-2"
                                 data-bs-parent="#accordionExample">
                                <Link className="sidebar-link py-2 px-3" to="/xml">
                                    XML Validation
                                </Link>
                                <Link className="sidebar-link py-2 px-3" to="/soap">
                                    SOAP
                                </Link>
                                <Link className="sidebar-link py-2 px-3" to="/xml/rpc">
                                    XML-RPC
                                </Link>
                                <Link className="sidebar-link py-2 px-3" to="/crud">
                                    CRUD
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}