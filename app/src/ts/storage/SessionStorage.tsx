import {ACCESS_TOKEN, REFRESH_TOKEN} from "../util/Constants.tsx";

export function getAccessToken() {
    return sessionStorage.getItem(ACCESS_TOKEN);
}

export function getRefreshToken() {
    return sessionStorage.getItem(REFRESH_TOKEN);
}

export function addToken(token: string, type: string) {
    sessionStorage.setItem(type, token);
}