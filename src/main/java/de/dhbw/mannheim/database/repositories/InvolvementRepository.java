package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Involvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvolvementRepository extends JpaRepository<Involvement, Long> {

    List<Involvement> findByProcess_Id(Long id);
}
