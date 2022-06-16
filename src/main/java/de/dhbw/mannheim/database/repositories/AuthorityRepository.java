package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByAuthorityInvolvedProcesses_Process_Id(Long id);

    List<Authority> findByAuthorityResponsibleCitizens_Citizen_Id(Long id);

}
