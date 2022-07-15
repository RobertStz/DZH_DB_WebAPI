export class Adress{

  id: number;
  street: string;
  streetNumber: string;
  postcode: string;
  city: string;

  constructor(id: number,street: string,streetNumber: string,postcode: string,city: string) {
    this.id = id;
    this.street = street;
    this.streetNumber = streetNumber;
    this.postcode = postcode;
    this.city = city;
  }
}
