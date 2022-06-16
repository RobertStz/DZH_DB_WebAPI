package de.dhbw.mannheim.services.citizen;


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
public class CitizenService implements ICitizenService {

    private final CitizenRepository citizenRepository;
    private final AuthorityRepository authorityRepository;
    private final MessageRepository messageRepository;
    private final ProcessRepository processRepository;

    public CitizenService(CitizenRepository citizenRepository, AuthorityRepository authorityRepository, MessageRepository messageRepository, ProcessRepository processRepository) {
        this.citizenRepository = citizenRepository;
        this.authorityRepository = authorityRepository;
        this.messageRepository = messageRepository;
        this.processRepository = processRepository;
    }

    @Override
    public Citizen login(String name, String password) {
        Citizen citizen = this.citizenRepository.findByEmailAllIgnoreCase(name);
        if (citizen.getPassword().equals(password))
            return citizen;
        else
            return null;
    }

    @Override
    public Citizen get(Long id) {
        Optional<Citizen> citizen = this.citizenRepository.findById(id);
        if (citizen.isEmpty())
            return null;
        else
            return citizen.get();
    }

    @Override
    public Citizen create(Citizen citizen) {
        return this.citizenRepository.save(citizen);
    }

    @Override
    public Citizen update(Long id, Citizen citizen) {
        if (this.citizenRepository.existsById(id))
            return this.citizenRepository.save(citizen);
        else
            return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (this.citizenRepository.existsById(id)) {
            this.citizenRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public List<Message> getMessagesByCitizen(Long id) {
        return this.messageRepository.findByCitizen_Id(id);
    }

    @Override
    public List<Authority> getAuthoritiesByCitizen(Long id) {
        return this.authorityRepository.findByAuthorityResponsibleCitizens_Citizen_Id(id);
    }

    @Override
    public List<Process> getProcessesByCitizen(Long id) {
        return this.processRepository.findByCitizen_Id(id);
    }

    @Override
    public List<Citizen> getKids(Long id) {
        return this.citizenRepository.findKids(id);
    }
}
