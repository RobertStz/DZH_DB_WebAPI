package de.dhbw.mannheim.services.involvement;

import de.dhbw.mannheim.database.entities.Involvement;
import de.dhbw.mannheim.database.repositories.InvolvementRepository;
import org.springframework.stereotype.Service;

@Service
public class InvolvementService implements IInvolvementService {

    private final InvolvementRepository involvementRepository;

    public InvolvementService(InvolvementRepository involvementRepository) {
        this.involvementRepository = involvementRepository;
    }

    @Override
    public Involvement insert(Involvement involvement) {
        if (involvement.getId().equals(0L))
            this.involvementRepository.save(involvement);
        return null;
    }

    @Override
    public Involvement update(Long id, Involvement involvement) {
        if (involvement.getId().equals(id) && this.involvementRepository.existsById(id))
            return this.involvementRepository.save(involvement);
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (this.involvementRepository.existsById(id)) {
            this.involvementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
