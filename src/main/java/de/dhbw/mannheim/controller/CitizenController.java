package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Citizen;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;
import de.dhbw.mannheim.services.citizen.ICitizenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citizens")
@Tag(name = "Bürger")
public class CitizenController {

    private final ICitizenService citizenService;

    public CitizenController(ICitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public ResponseEntity<Citizen> login(String email, String password) {
        Citizen citizen = this.citizenService.login(email, password);
        if(citizen == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(citizen, HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<Citizen> get(@PathVariable Long id) {
        Citizen citizen = this.citizenService.getCitizen(id);
        if(citizen == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(citizen, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Citizen> create(@RequestBody Citizen citizen) {
        Citizen savedCitizen = this.citizenService.createCitizen(citizen);
        if(savedCitizen == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Citizen> update(@PathVariable Long id, @RequestBody Citizen citizen) {
        Citizen savedCitizen = this.citizenService.updateCitizen(id, citizen);
        if(savedCitizen == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if(this.citizenService.deleteCitizen(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long id) {
        return new ResponseEntity<>(this.citizenService.getMessagesByCitizen(id), HttpStatus.FOUND);
    }

    @GetMapping("{id}/processes")
    public ResponseEntity<List<Process>> getProcesses(@PathVariable Long id) {
        return new ResponseEntity<>(this.citizenService.getProcessesByCitizen(id),HttpStatus.FOUND);
    }

    @GetMapping("{id}/authorities")
    public ResponseEntity<List<Authority>> getAuthorities(@PathVariable Long id) {
        return new ResponseEntity<>(this.citizenService.getAuthoritiesByCitizen(id), HttpStatus.FOUND);
    }

    @GetMapping("{id}/kids")
    public ResponseEntity<List<Citizen>> getKids(@PathVariable Long id) {
        return new ResponseEntity<>(this.citizenService.getKidsByCitizen(id), HttpStatus.FOUND);
    }
}
