package de.dhbw.mannheim.services.process;

import de.dhbw.mannheim.database.entities.*;
import de.dhbw.mannheim.database.entities.Process;

import java.util.List;

public interface IProcessService {

    Process getProcess(Long id);
    Process insertProcess(Process process);
    Process updateProcess(Long id, Process process);
    Boolean deleteProcess(Long id);

    List<Message> getMessagesByProcess(Long id);

    List<Authority> getAuthoritiesByProcess(Long id);

    List<Involvement> getInvolvementsByProcess(Long id);

}
