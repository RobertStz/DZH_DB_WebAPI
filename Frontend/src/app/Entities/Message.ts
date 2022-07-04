import {Citizen} from "./Citizen";
import {Process} from "./Process";
import {Authority} from "./Authority";

export class Message{

  id: number;
  content: string;
  citizen: Citizen;
  process: Process;
  authority: Authority;

  constructor(id: number,content: string,citizen: Citizen,process: Process,authority: Authority) {
    this.id = id;
    this.content = content;
    this.citizen = citizen;
    this.process= process;
    this.authority = authority;
  }
}
