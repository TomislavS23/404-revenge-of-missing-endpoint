import {XML_VALIDATION_ENDPOINT} from "../util/Constants.tsx";

export async function validateXml(xml: string, operation: string) {
    const endpoint = operation === "1" ? 'xsd' : 'rng';
    const cleanedXml = xml.trim();

    const response = await fetch(`${XML_VALIDATION_ENDPOINT}${endpoint}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/xml",
        },
        body: cleanedXml,
        credentials: "include",
        mode: "cors",
    });

    if (!response.ok) {
        return await response.text()
    }

    return response.ok ? "SUCCESS" : "ERROR";
}