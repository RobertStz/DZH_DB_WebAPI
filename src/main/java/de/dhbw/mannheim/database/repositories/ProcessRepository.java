package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Process;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    List<Process> findByCitizen_Id(Long id);

    List<Process> findByAuthorityInvolvedProcesses_Authority_Id(Long id);




}
