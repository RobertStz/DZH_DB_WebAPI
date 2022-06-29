package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Involvement;
import de.dhbw.mannheim.database.entities.Responsibility;
import de.dhbw.mannheim.services.involvement.IInvolvementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("involvements")
@Tag(name = "Behördenbeteiligung")
public class InvolvementController {

    private final IInvolvementService involvementService;

    public InvolvementController(IInvolvementService involvementService) {
        this.involvementService = involvementService;
    }

    @PostMapping
    public ResponseEntity<Involvement> create(Involvement involvement) {
        Involvement result = this.involvementService.insert(involvement);
        if(result == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Involvement> update(@PathVariable Long id, Involvement involvement) {
        Involvement result = this.involvementService.update(id, involvement);
        if(result == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if(this.involvementService.delete(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
