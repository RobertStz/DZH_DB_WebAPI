package de.dhbw.mannheim.services.responsibility;

import de.dhbw.mannheim.database.entities.Responsibility;
import de.dhbw.mannheim.database.repositories.ResponsibilityRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponsibilityService implements IResponsibilityService {

    private final ResponsibilityRepository responsibilityRepository;

    public ResponsibilityService(ResponsibilityRepository responsibilityRepository) {
        this.responsibilityRepository = responsibilityRepository;
    }


    @Override
    public Responsibility insert(Responsibility responsibility) {

        return null;
    }

    @Override
    public Responsibility update(Long id, Responsibility responsibility) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
