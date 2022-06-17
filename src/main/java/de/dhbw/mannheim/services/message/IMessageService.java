package de.dhbw.mannheim.services.message;

import de.dhbw.mannheim.database.entities.Message;

public interface IMessageService {

    Message getMessage(Long id);
    Message insertMessage(Message message);
    Message updateMessage(Long id, Message message);
    Boolean deleteMessage(Long id);

}
