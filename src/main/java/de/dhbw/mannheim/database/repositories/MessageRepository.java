package de.dhbw.mannheim.database.repositories;

import de.dhbw.mannheim.database.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByCitizen_Id(Long id);

    List<Message> findByProcess_Id(Long id);

    List<Message> findByAuthority_Id(Long id);
}
