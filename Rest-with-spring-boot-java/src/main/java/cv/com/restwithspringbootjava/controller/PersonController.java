package cv.com.restwithspringbootjava.controller;

import cv.com.restwithspringbootjava.dto.PersonDto;
import cv.com.restwithspringbootjava.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO implement tests for endpoints

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findAll() {
        return personService.findAll();
    }

    @PostMapping(
            value = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PutMapping(value = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto update(@RequestBody PersonDto personDto) {
        return personService.update(personDto);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
