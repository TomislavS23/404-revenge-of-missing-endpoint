import {useState} from "react";
import * as React from "react";
import Sidebar from "../Sidebar.tsx";
import {retrieveCities} from "../../ts/rest/RpcRest.tsx";
import {CityDto} from "../../ts/model/City.tsx";

export default function Rpc() {
    const [city, setCity] = useState('');
    const [response, setResponse] = useState<CityDto[]>([]);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        try {
            const cities = await retrieveCities(city);
            setResponse(cities);
        } catch (error) {
            console.error("Error fetching cities:", error);
            setResponse([]);
        }
    };

    return (
        <>
            <div className="d-flex h-100">
                <Sidebar/>
                <div id="content" className="d-flex w-100 p-4">
                    <div className="w-50 pe-4">
                        <div className={"card mb-3 p-4"} data-bs-theme={"dark"}>
                            <form onSubmit={handleSubmit} className="mb-3">
                                <div className="mb-3">
                                    <input
                                        className="form-control"
                                        onChange={(e) => setCity(e.target.value)}
                                        placeholder="Enter city here..."
                                    />
                                </div>
                                <button type="submit" className="btn btn-primary">
                                    Submit
                                </button>
                            </form>
                        </div>
                    </div>
                    <div className="w-50 ps-4">
                        <div className="card" data-bs-theme={"dark"}>
                            <div className="card-body">
                                <h5 className="card-title">Result</h5>
                                <div className="card-text">
                                    {response.length > 0 ? (
                                        <pre>{JSON.stringify(response, null, 2)}</pre>
                                    ) : (
                                        <p>No results found</p>
                                    )}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}