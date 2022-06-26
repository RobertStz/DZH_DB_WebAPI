package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.services.message.IMessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
@Tag(name = "Nachrichten")
public class MessageController {

    private final IMessageService messageService;

    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("{id}")
    public ResponseEntity<Message> get(@PathVariable Long id) {
        Message message = this.messageService.getMessage(id);
        if(message == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Message> create(Message message) {
        Message savedMessage = this.messageService.insertMessage(message);
        if(savedMessage == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Message> update(@PathVariable Long id, Message message) {
        Message savedMessage = this.messageService.updateMessage(id, message);
        if(savedMessage == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(savedMessage, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if(this.messageService.deleteMessage(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
