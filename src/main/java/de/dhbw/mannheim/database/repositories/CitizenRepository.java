package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    List<Citizen> findByAuthorityResponsibleCitizens_Authority_Id(Long id);

    @Query("select distinct c from Citizen c where c.mother.id = ?1 or c.father.id = ?1")
    List<Citizen> findKids(Long id);

    Citizen findByEmailAllIgnoreCase(String email);


}
