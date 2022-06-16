package de.dhbw.mannheim.services.process;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;

import java.util.List;

public interface IProcessService {

    Process get(Long id);
    Process insert(Process process);
    Process update(Long id, Process process);
    Boolean delete(Long id);

    List<Message> getMessagesByProcess(Long id);

    List<Authority> getAuthoritiesByProcess(Long id);

}
