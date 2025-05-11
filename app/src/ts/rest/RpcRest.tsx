import {RPC_ENDPOINT} from "../util/Constants.tsx";
import {CityDto} from "../model/City.tsx";

export async function retrieveCities(filter: string) : Promise<CityDto[]> {
    const response = await fetch(`${RPC_ENDPOINT}${filter}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        credentials: "include",
        mode: "cors",
    });

    if (!response.ok) {
        console.error(response.statusText);
    }

    const json = await response.json();
    return Array.isArray(json) ? json : [json];
}