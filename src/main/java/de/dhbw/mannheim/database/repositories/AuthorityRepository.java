package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Query("""
            select distinct a from Authority a left join a.sourceInvolvements sourceInvolvements left join a.targetInvolvements targetInvolvements
            where sourceInvolvements.sourceAuthority.id = ?1 or sourceInvolvements.targetAuthority.id = ?1 or targetInvolvements.sourceAuthority.id = ?1 or targetInvolvements.targetAuthority.id = ?1""")
    List<Authority> findAllByProcess(Long id);

    List<Authority> findByResponsibilities_Citizen_Id(Long id);




}
