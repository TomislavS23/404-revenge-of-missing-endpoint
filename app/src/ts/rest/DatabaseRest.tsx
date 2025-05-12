import {PRODUCT_ENDPOINT} from "../util/Constants.tsx";
import {UpdateProductDto} from "../model/UpdateProductDto.tsx";

export async function getProducts() {
    const response = await fetch(`${PRODUCT_ENDPOINT}`, {
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

export async function getProductById(id: string) {
    const response = await fetch(`${PRODUCT_ENDPOINT}/${id}`, {
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

export async function deleteProduct(id: string) {
    const response = await fetch(`${PRODUCT_ENDPOINT}/${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
        credentials: "include",
        mode: "cors",
    });

    if (!response.ok) {
        console.error(response.statusText);
    }

    return "PRODUCT DELETED SUCCESSFULLY!";
}

export async function updateProduct(data: UpdateProductDto) {
    const response = await fetch(`${PRODUCT_ENDPOINT}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
        credentials: "include",
        mode: "cors",
    });

    if (!response.ok) {
        console.error(response.statusText);
    }

    return "PRODUCT UPDATED SUCCESSFULLY!";
}