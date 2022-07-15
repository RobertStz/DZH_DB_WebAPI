package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
