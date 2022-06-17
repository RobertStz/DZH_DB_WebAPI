package de.dhbw.mannheim.services.message;

import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message getMessage(Long id) {
        Optional<Message> message = this.messageRepository.findById(id);
        if (message.isEmpty())
            return null;
        else
            return message.get();
    }

    @Override
    public Message insertMessage(Message message) {
        return this.messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long id, Message message) {
        if (this.messageRepository.existsById(id) && message.getId().equals(id))
            return this.messageRepository.save(message);
        else
            return null;
    }

    @Override
    public Boolean deleteMessage(Long id) {
        if (this.messageRepository.existsById(id)) {
            this.messageRepository.deleteById(id);
            return true;
        } else
            return false;
    }
}
