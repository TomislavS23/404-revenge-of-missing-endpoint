import LoginRequestDto from "../model/LoginRequestDto.tsx";
import TokenDto from "../model/TokenDto.tsx";
import {addToken, getAccessToken} from "./SessionStorage.tsx";
import {ACCESS_TOKEN, ACCESS_TOKEN_HEADER, REFRESH_TOKEN} from "../util/Constants.tsx";

export async function login(username: string, password: string): Promise<void> {
    const loginRequest = new LoginRequestDto(username, password);

    const response = await fetch(AUTH_ENDPOINT + 'login', {
        headers: {
            "Content-Type": "application/json",
            //"X-REFRESH-TOKEN": refreshToken || "",
            //"Authorization": `Bearer ${accessToken}`,
        },
        body: JSON.stringify(loginRequest),
        credentials: "include",
        method: "POST",
        mode: "cors",
    })

    if (!response.ok) {
        document.getElementById("login-warning").hidden = false;
        throw new Error('Login failed');
    }

    document.getElementById("login").hidden = true;
    document.getElementById("logout").hidden = false;
    const tokens = await response.json() as TokenDto;
    addToken(tokens.accessToken, ACCESS_TOKEN);
    addToken(tokens.refreshToken, REFRESH_TOKEN);
}

export async function logout(): Promise<void> {
    sessionStorage.removeItem(REFRESH_TOKEN);
    sessionStorage.removeItem(ACCESS_TOKEN);
    document.getElementById("login").hidden = false;
    document.getElementById("logout").hidden = true;
}

export async function refreshToken(response: Response): Promise<void> {
    const newAccessToken = response.headers.get(ACCESS_TOKEN_HEADER);

    if (!newAccessToken) {
        return;
    }

    console.log("Token has been refreshed.")
    addToken(newAccessToken, ACCESS_TOKEN);
}

export function getUserRole(): string[] {
    const token = getAccessToken();
    if (!token) return [];

    const payload = JSON.parse(atob(token.split('.')[1]));
    return payload.authorities;
}

export function getUsername(): string {
    const token = getAccessToken();
    if (!token) return "";

    const payload = JSON.parse(atob(token.split('.')[1]));
    return payload.sub;
}