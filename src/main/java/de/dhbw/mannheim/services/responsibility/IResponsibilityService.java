package de.dhbw.mannheim.services.responsibility;

import de.dhbw.mannheim.database.entities.Responsibility;

public interface IResponsibilityService {

    Responsibility insert(Responsibility responsibility);

    Responsibility update(Long id, Responsibility responsibility);

    Boolean delete(Long id);


}
