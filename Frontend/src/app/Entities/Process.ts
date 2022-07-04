import {Citizen} from "./Citizen";

export class Process{

  id: number;
  name: string;
  citizen: Citizen;

  constructor(id: number,name: string,citizen: Citizen) {
    this.id = id;
    this.name = name;
    this.citizen = citizen;
  }

}
