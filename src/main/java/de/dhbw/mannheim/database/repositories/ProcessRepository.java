package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    List<Process> findByCitizen_Id(Long id);

    @Query("""
            select p from Process p inner join p.involvements involvements
            where involvements.sourceAuthority.id = ?1 or involvements.targetAuthority.id = ?1""")
    List<Process> findByInvolvements(Long id);






}
