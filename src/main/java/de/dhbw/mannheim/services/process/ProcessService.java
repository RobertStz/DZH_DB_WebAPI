package de.dhbw.mannheim.services.process;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;
import de.dhbw.mannheim.database.repositories.AuthorityRepository;
import de.dhbw.mannheim.database.repositories.MessageRepository;
import de.dhbw.mannheim.database.repositories.ProcessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessService implements IProcessService {

    private final ProcessRepository processRepository;
    private final MessageRepository messageRepository;
    private final AuthorityRepository authorityRepository;

    public ProcessService(ProcessRepository processRepository, MessageRepository messageRepository, AuthorityRepository authorityRepository) {
        this.processRepository = processRepository;
        this.messageRepository = messageRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Process getProcess(Long id) {
        Optional<Process> process = this.processRepository.findById(id);
        if (process.isEmpty())
            return null;
        else
            return process.get();
    }

    @Override
    public Process insertProcess(Process process) {
        if(!process.getId().equals(0L))
            return null;
        return this.processRepository.save(process);
    }

    @Override
    public Process updateProcess(Long id, Process process) {
        if (this.processRepository.existsById(id) && process.getId().equals(id))
            return this.processRepository.save(process);
        else
            return null;
    }

    @Override
    public Boolean deleteProcess(Long id) {
        if (this.processRepository.existsById(id)) {
            this.processRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public List<Message> getMessagesByProcess(Long id) {
        return this.messageRepository.findByProcess_Id(id);
    }

    @Override
    public List<Authority> getAuthoritiesByProcess(Long id) {
        return this.authorityRepository.findByAuthorityInvolvedProcesses_Process_Id(id);
    }
}
