import Sidebar from "../Sidebar.tsx";
import {useState} from "react";
import {validateXml} from "../../ts/rest/XmlRest.tsx";
import * as React from "react";

export default function Xml() {
    const [xml, setXml] = useState("Write your XML value here...");
    const [result, setResult] = useState('');
    const [selectedOperation, setSelectedOperation] = useState("");

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        if (!selectedOperation) {
            setResult("Please select a validation method");
            return;
        }

        try {
            const validationResult = await validateXml(xml, selectedOperation);
            setResult(JSON.stringify(validationResult));
        } catch (error) {
            setResult(`Error: ${error.message}`);
        }
    };

    return (
        <>
            <div className="d-flex h-100">
                <Sidebar/>
                <div id="content" className="d-flex w-100 p-4">
                    <div className="w-50 pe-4">
                        <form onSubmit={handleSubmit} className="mb-3">
                            <div className="mb-3">
                                <select
                                    id="operation"
                                    className="form-select mb-3"
                                    value={selectedOperation}
                                    onChange={(e) => setSelectedOperation(e.target.value)}
                                    required={true}
                                >
                                    <option value="" disabled={true}>Select Operation</option>
                                    <option value="1">Validate against XSD</option>
                                    <option value="2">Validate against RNG</option>
                                </select>

                                <textarea
                                    className="form-control"
                                    rows={20}
                                    value={xml}
                                    onChange={(e) => setXml(e.target.value)}
                                    placeholder="Enter your text here..."
                                />
                            </div>
                            <button type="submit" className="btn btn-primary">
                                Process Text
                            </button>
                        </form>
                    </div>
                    <div className="w-50 ps-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Result</h5>
                                <div className="card-text text-dark">
                                    {result}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}