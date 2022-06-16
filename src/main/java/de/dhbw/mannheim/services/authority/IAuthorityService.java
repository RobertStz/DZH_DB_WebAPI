package de.dhbw.mannheim.services.authority;


import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Citizen;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;

import java.util.List;

public interface IAuthorityService {

    Authority get(Long id);
    Authority insert(Authority authority);
    Authority update(Long id, Authority authority);
    Boolean delete(Long id);
    List<Message> getMessagesByAuthority(Long id);
    List<Process> getProcessesByAuthority(Long id);
    List<Citizen> getCitizensByAuthority(Long id);


}
