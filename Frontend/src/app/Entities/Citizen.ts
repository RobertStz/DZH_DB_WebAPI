import {Gender} from "./Gender";

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
  birthDay: Date;
  gender: Gender;
  mother: string;
  father: string;
  constructor(id: number,taxId: string,email: string,password: string,titel: string,name: string,birthName: string,
              firstName: string,birthPlace: string,birthCountry: string,birthDay: Date,gender: Gender,mother: string,
              father: string) {

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
    this.birthDay = birthDay;
    this.gender = gender;
    this.mother = mother;
    this.father = father;
  }

}
