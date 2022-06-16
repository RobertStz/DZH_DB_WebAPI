package de.dhbw.mannheim.services.citizen;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Citizen;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;

import java.util.List;

public interface ICitizenService {

    Citizen login(String name, String password);
    Citizen get(Long id);
    Citizen create (Citizen citizen);
    Citizen update(Long id, Citizen citizen);
    Boolean delete(Long id);
    List<Message> getMessagesByCitizen(Long id);
    List<Authority> getAuthoritiesByCitizen(Long id);
    List<Process> getProcessesByCitizen(Long id);
    List<Citizen> getKids(Long id);

}
