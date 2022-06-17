package de.dhbw.mannheim.services.authority;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Citizen;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;
import de.dhbw.mannheim.database.repositories.AuthorityRepository;
import de.dhbw.mannheim.database.repositories.CitizenRepository;
import de.dhbw.mannheim.database.repositories.MessageRepository;
import de.dhbw.mannheim.database.repositories.ProcessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService implements IAuthorityService {

    private final AuthorityRepository authorityRepository;
    private final MessageRepository messageRepository;
    private final ProcessRepository processRepository;
    private final CitizenRepository citizenRepository;
    public AuthorityService(AuthorityRepository authorityRepository, MessageRepository messageRepository, ProcessRepository processRepository, CitizenRepository citizenRepository) {
        this.authorityRepository = authorityRepository;
        this.messageRepository = messageRepository;
        this.processRepository = processRepository;
        this.citizenRepository = citizenRepository;
    }

    @Override
    public Authority getAuthority(Long id) {
        Optional<Authority> authority = this.authorityRepository.findById(id);
        if (authority.isEmpty())
            return null;
        else
            return authority.get();
    }

    @Override
    public Authority insertAuthority(Authority authority) {
        return this.authorityRepository.save(authority);
    }

    @Override
    public Authority updateAuthority(Long id, Authority authority) {
        if (this.authorityRepository.existsById(id) && id.equals(authority.getId()))
            return this.authorityRepository.save(authority);
        else
            return null;
    }

    @Override
    public Boolean deleteAuthority(Long id) {
        if (!this.authorityRepository.existsById(id))
            return false;
        else {
            this.authorityRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public List<Message> getMessagesByAuthority(Long id) {
        return this.messageRepository.findByAuthority_Id(id);
    }

    @Override
    public List<Process> getProcessesByAuthority(Long id) {
        return this.processRepository.findByAuthorityInvolvedProcesses_Authority_Id(id);
    }

    @Override
    public List<Citizen> getCitizensByAuthority(Long id) {
        return this.citizenRepository.findByAuthorityResponsibleCitizens_Authority_Id(id);
    }
}
