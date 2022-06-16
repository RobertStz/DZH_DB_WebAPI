package de.dhbw.mannheim.services.message;

import de.dhbw.mannheim.database.entities.Message;

public interface IMessageService {

    Message get(Long id);
    Message insert(Message message);
    Message update(Long id, Message message);
    Boolean delete(Long id);

}
