import {SOAP_ENDPOINT} from "../util/Constants.tsx";

export async function retrieveProducts(price: string) : Promise<string> {
    const response = await fetch(`${SOAP_ENDPOINT}search?price=${price}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/xml",
        },
        credentials: "include",
        mode: "cors",
    });

    if (!response.ok) {
        return await response.text()
    }

    return response.text();
}