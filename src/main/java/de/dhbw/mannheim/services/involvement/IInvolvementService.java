package de.dhbw.mannheim.services.involvement;

import de.dhbw.mannheim.database.entities.Involvement;

public interface IInvolvementService {

    Involvement insert(Involvement involvement);

    Involvement update(Long id, Involvement involvement);

    Boolean delete(Long id);

}
