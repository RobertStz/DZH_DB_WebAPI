import {Authority} from "./Authority";
import {Process} from "./Process";

export class Involments{

  id:number;
  sourceAuthority: Authority;
  targetAuthority: Authority;
  process: Process;
  permission: string;

  constructor(id:number,sourceAuthority: Authority,targetAuthority: Authority,process: Process, permission: string) {
    this.id = id;
    this.sourceAuthority = sourceAuthority;
    this.targetAuthority = targetAuthority;
    this.process = process;
    this.permission = permission;

  }


}
