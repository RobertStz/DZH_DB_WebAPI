package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;
import de.dhbw.mannheim.services.process.IProcessService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("processes")
@Tag(name = "Vorgänge")
public class ProcessController {

    private final IProcessService processService;

    public ProcessController(IProcessService processService) {
        this.processService = processService;
    }


    public ResponseEntity<Process> get(@PathVariable Long id) {
        Process process = this.processService.getProcess(id);
        if (process == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(process, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Process> create(Process process) {
        Process savedProcess = this.processService.insertProcess(process);
        if (savedProcess == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(savedProcess, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Process> update(@PathVariable Long id, Process process) {
        Process savedProcess = this.processService.updateProcess(id, process);
        if (savedProcess == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(savedProcess, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (this.processService.deleteProcess(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


    @GetMapping("{id}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long id) {
        return new ResponseEntity<>(this.processService.getMessagesByProcess(id), HttpStatus.OK);
    }

    @GetMapping("{id}/authorities")
    public ResponseEntity<List<Authority>> getAuthorities(@PathVariable Long id) {
        return new ResponseEntity<>(this.processService.getAuthoritiesByProcess(id), HttpStatus.OK);
    }
}
