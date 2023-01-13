package cv.com.restwithspringbootjava.controller;

import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import cv.com.restwithspringbootjava.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(tags = "Person")
    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @Operation(tags = "Person")
    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findAll() {
        return personService.findAll();
    }

    @Operation(tags = "Person")
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @Operation(tags = "Person")
    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto update(@RequestBody PersonDto personDto) {
        return personService.update(personDto);
    }

    @Operation(tags = "Person")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
