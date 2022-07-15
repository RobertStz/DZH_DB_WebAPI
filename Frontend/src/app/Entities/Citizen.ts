import {Gender} from "./Gender";
import {Adress} from "./Adress";


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
  adress: Adress;
  constructor(id: number,taxId: string,email: string,password: string,titel: string,name: string,birthName: string,
              firstName: string,birthPlace: string,birthCountry: string,birthday: Date,gender: Gender,mother: string,
              father: string, adress: Adress) {

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
    this.adress = adress;
  }

}
