import {Gender} from "./Gender";
import {Address} from "./Address";


export class Citizen{

  id: number;
  taxId: string;
  email: string;
  password: string;
  titel: string;
  name: string;
  birthName: string;
  firstName: string;
  birthPlace: string;
  birthCountry: string;
  birthday: Date;
  gender: Gender;
  mother: string;
  father: string;
  address: Address;
  constructor(id: number,taxId: string,email: string,password: string,titel: string,name: string,birthName: string,
              firstName: string,birthPlace: string,birthCountry: string,birthday: Date,gender: Gender,mother: string,
              father: string, address: Address) {

    this.id = id;
    this.taxId = taxId;
    this.email = email;
    this.password = password;
    this.titel = titel;
    this.name = name;
    this.birthName = birthName;
    this.firstName = firstName;
    this.birthPlace = birthPlace;
    this.birthCountry = birthCountry;
    this.birthday = birthday;
    this.gender = gender;
    this.mother = mother;
    this.father = father;
    this.address = address;
  }

}
