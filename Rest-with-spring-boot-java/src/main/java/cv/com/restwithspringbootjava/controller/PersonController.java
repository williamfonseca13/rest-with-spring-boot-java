package cv.com.restwithspringbootjava.controller;

import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "Person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable(value = "id") String id) {
        return personService.findById(id);
    }

    @GetMapping(value = "findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
