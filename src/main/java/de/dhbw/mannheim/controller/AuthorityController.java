package de.dhbw.mannheim.controller;


import de.dhbw.mannheim.database.entities.Authority;
import de.dhbw.mannheim.database.entities.Citizen;
import de.dhbw.mannheim.database.entities.Message;
import de.dhbw.mannheim.database.entities.Process;

import de.dhbw.mannheim.services.authority.IAuthorityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("authorities")
@Tag(name = "Behörden")
public class AuthorityController {

    private final IAuthorityService authorityService;


    public AuthorityController(IAuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Authority> get(@PathVariable Long id) {
        Authority authority = this.authorityService.getAuthority(id);
        if (authority == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(authority, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Authority> create(@RequestBody Authority authority) {
        Authority savedAuthority = this.authorityService.insertAuthority(authority);
        if (savedAuthority == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(savedAuthority, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Authority> update(@PathVariable Long id, Authority authority) {
        Authority savedAuthority = this.authorityService.updateAuthority(id, authority);
        if (savedAuthority != null)
            return new ResponseEntity<>(savedAuthority, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (this.authorityService.deleteAuthority(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long id) {
        return new ResponseEntity<>(this.authorityService.getMessagesByAuthority(id), HttpStatus.OK);
    }

    @GetMapping("{id}/processes")
    public ResponseEntity<List<Process>> getProcesses(@PathVariable Long id) {
        return new ResponseEntity<>(this.authorityService.getProcessesByAuthority(id), HttpStatus.OK);
    }

    @GetMapping("{id}/citizens")
    public ResponseEntity<List<Citizen>> getCitizens(@PathVariable Long id) {
        return new ResponseEntity<>(this.authorityService.getCitizensByAuthority(id), HttpStatus.OK);
    }

}
