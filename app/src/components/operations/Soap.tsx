import {useState} from "react";
import * as React from "react";
import Sidebar from "../Sidebar.tsx";
import {retrieveProducts} from "../../ts/rest/SoapRest.tsx";

export default function Soap() {
    const [price, setPrice] = useState('');
    const [response, setResponse] = useState('');

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        retrieveProducts(price).then((r) => {
            setResponse(r);
        })
    };

    return (
        <>
            <div className="d-flex h-100">
                <Sidebar/>
                <div id="content" className="d-flex w-100 p-4">
                    <div className="w-50 pe-4">
                        <form onSubmit={handleSubmit} className="mb-3">
                            <div className="mb-3">
                                <input
                                    type="number"
                                    step="0.01"
                                    className="form-control"
                                    onChange={(e) => setPrice(e.target.value)}
                                    placeholder="Enter valid price here..."
                                />
                            </div>
                            <button type="submit" className="btn btn-primary">
                                Submit
                            </button>
                        </form>
                    </div>
                    <div className="w-50 ps-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Result</h5>
                                <div className="card-text text-dark">
                                    {response}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}