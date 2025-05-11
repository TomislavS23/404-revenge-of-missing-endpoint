export interface CityDto {
    gradIme: string,
    lat: number,
    lon: number,
    podatci: WeatherDataDto,
    autom: number
}

export interface WeatherDataDto {
    temp: number,
    vlaga: number,
    tlak: number,
    tlakTend: number | null,
    vjetarSmjer: string,
    vjetarBrzina: number,
    vrijeme: string,
    vrijemeZnak: string
}