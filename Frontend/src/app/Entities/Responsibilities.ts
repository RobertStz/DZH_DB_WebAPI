import { Authority} from "./Authority";
import {Citizen} from "./Citizen";

export class Responsibilities{

  id:number;
  name:string;
  authority: Authority;
  citizen: Citizen;

  constructor( id:number,name:string,authority: Authority,citizen: Citizen) {
  this.id = id;
  this.name = name;
  this.authority = authority;
  this.citizen = citizen;
  }

}
