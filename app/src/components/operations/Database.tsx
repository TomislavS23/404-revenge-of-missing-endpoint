import Sidebar from "../Sidebar.tsx";
import {useState} from "react";
import * as React from "react";
import {deleteProduct, getProductById, getProducts, updateProduct} from "../../ts/rest/DatabaseRest.tsx";
import {UpdateProductDto} from "../../ts/model/UpdateProductDto.tsx";

export default function Database() {
    const [price, setPrice] = useState('');
    const [productId, setProductId] = useState('');
    const [response, setResponse] = useState('');

    const handleGet = async (e: React.FormEvent) => {
        e.preventDefault();

        getProducts().then((r) => {
            setResponse(r);
        })
    };

    const handleGetById = async (e: React.FormEvent) => {
        e.preventDefault();

        getProductById(productId).then((r) => {
            setResponse(r);
        })
    };

    const handleDelete = async (e: React.FormEvent) => {
        e.preventDefault();

        deleteProduct(productId).then((r) => {
            setResponse(r);
        })
    }

    const handlePut = async (e: React.FormEvent) => {
        e.preventDefault();

        const dto = new UpdateProductDto(Number(productId), Number(price));
        updateProduct(dto).then((r) => {
            setResponse(r);
        })
    }

    return (
        <>
            <div className="d-flex h-100">
                <Sidebar/>
                <div id="content" className="d-flex w-100 p-4">
                    <div className="w-50 pe-4">

                        <button className={"btn btn-primary w-100"} onClick={handleGet}>GET</button>

                        <div className="border-2 border-bottom my-3"></div>

                        <div className={"card mb-3 p-4"} data-bs-theme={"dark"}>
                            <form className="mb-3" onSubmit={handleGetById}>
                                <div className="mb-3">
                                    <label className="form-label">Product ID</label>
                                    <input
                                        type="number"
                                        step="1"
                                        className="form-control"
                                        placeholder="Enter valid id..."
                                        onChange={(e) => setProductId(e.target.value)}
                                    />
                                </div>
                                <button type="submit" className="btn btn-primary w-100">
                                    GET BY ID
                                </button>
                            </form>
                        </div>

                        <div className="border-2 border-bottom my-3"></div>

                        <div className={"card mb-3 p-4"} data-bs-theme={"dark"}>
                            <form className="mb-3" onSubmit={handlePut}>
                                <label className="form-label">Product ID</label>
                                <div className="mb-3">
                                    <input
                                        type="number"
                                        step="1"
                                        className="form-control"
                                        placeholder="Enter valid id..."
                                        onChange={(e) => setProductId(e.target.value)}
                                    />

                                    <label className="form-label mt-3">Price</label>
                                    <input
                                        type="number"
                                        step="0.01"
                                        className="form-control"
                                        placeholder="Enter valid id..."
                                        onChange={(e) => setPrice(e.target.value)}
                                    />
                                </div>
                                <button type="submit" className="btn btn-warning w-100">
                                    PUT
                                </button>
                            </form>
                        </div>

                        <div className="border-2 border-bottom my-3"></div>

                        <div className={"card mb-3 p-4"} data-bs-theme={"dark"}>
                            <form className="mb-3" onSubmit={handleDelete}>
                                <div className="mb-3">
                                    <label className="form-label">Product ID</label>
                                    <input
                                        type="number"
                                        step="0.01"
                                        className="form-control"
                                        placeholder="Enter valid id..."
                                        onChange={(e) => setProductId(e.target.value)}
                                    />
                                </div>
                                <button type="submit" className="btn btn-danger w-100">
                                    DELETE
                                </button>
                            </form>
                        </div>
                    </div>
                    <div className="w-50 ps-4" data-bs-theme={"dark"}>
                        <div className="card">
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