package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Involvement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibilityRepository extends CrudRepository<Involvement, Long> {

}
