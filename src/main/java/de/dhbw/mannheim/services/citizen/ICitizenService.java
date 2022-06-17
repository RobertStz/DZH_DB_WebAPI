package de.dhbw.mannheim.services.citizen;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Citizen;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;

import java.util.List;

public interface ICitizenService {

    Citizen login(String name, String password);
    Citizen getCitizen(Long id);
    Citizen createCitizen (Citizen citizen);
    Citizen updateCitizen(Long id, Citizen citizen);
    Boolean deleteCitizen(Long id);
    List<Message> getMessagesByCitizen(Long id);
    List<Authority> getAuthoritiesByCitizen(Long id);
    List<Process> getProcessesByCitizen(Long id);
    List<Citizen> getKidsByCitizen(Long id);

}
