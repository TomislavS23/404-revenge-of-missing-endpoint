export class UpdateProductDto {
    id: number;
    price: number;

    constructor(id: number, price: number) {
        this.id = id;
        this.price = price;
    }
}