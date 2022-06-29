package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Responsibility;
import de.dhbw.mannheim.services.responsibility.IResponsibilityService;
import de.dhbw.mannheim.services.responsibility.ResponsibilityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("responsibility")
@Tag(name = "Zuständigkeiten")
public class ResponsibilityController {

    private final IResponsibilityService responsibilityService;

    public ResponsibilityController(IResponsibilityService responsibilityService) {
        this.responsibilityService = responsibilityService;
    }


    @PostMapping
    public ResponseEntity<Responsibility> create(Responsibility responsibility) {
        Responsibility result = this.responsibilityService.insert(responsibility);
        return null;
    }

    @PutMapping
    public ResponseEntity<Responsibility> update(@PathVariable Long id, Responsibility responsibility) {
        return null;
    }
}
