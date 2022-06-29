package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Responsibility;
import de.dhbw.mannheim.services.responsibility.IResponsibilityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("responsibilities")
@Tag(name = "Zuständigkeiten")
public class ResponsibilityController {

    private final IResponsibilityService responsibilityService;

    public ResponsibilityController(IResponsibilityService responsibilityService) {
        this.responsibilityService = responsibilityService;
    }


    @PostMapping
    public ResponseEntity<Responsibility> create(Responsibility responsibility) {
        Responsibility result = this.responsibilityService.insert(responsibility);
        if(result == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Responsibility> update(@PathVariable Long id, Responsibility responsibility) {
        Responsibility result = this.responsibilityService.update(id, responsibility);
        if(result == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
      if(this.responsibilityService.delete(id))
          return new ResponseEntity<>(true, HttpStatus.OK);
      return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
