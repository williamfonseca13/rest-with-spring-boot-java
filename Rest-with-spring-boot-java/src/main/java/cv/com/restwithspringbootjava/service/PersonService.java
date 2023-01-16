package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.controller.PersonController;
import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import cv.com.restwithspringbootjava.exception.ResourceNotFoundException;
import cv.com.restwithspringbootjava.mapper.DozerMapper;
import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDto findById(Long id) {

        final var person = getPersonById(id);

        final var personDto = DozerMapper.parseObject(person, PersonDto.class);
        personDto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

        return personDto;
    }

    public List<PersonDto> findAll() {
        final var persons = personRepository.findAll();
        return DozerMapper.parseListObjects(persons, PersonDto.class).stream()
                .map(obj -> obj.add(linkTo(methodOn(PersonController.class).findById(obj.getKey())).withSelfRel()))
                .toList();
    }

    public PersonDto create(PersonDto personDto) {

        final var person = DozerMapper.parseObject(personDto, Person.class);

        final Person savedPerson = personRepository.save(person);

        final var newPersonDto = DozerMapper.parseObject(savedPerson, PersonDto.class);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(personDto.getKey())).withSelfRel());

        return newPersonDto;
    }

    public PersonDto update(PersonDto personDto) {

        Objects.requireNonNull("It is not allowed to persist a null object!");

        final var entity = this.getPersonById(personDto.getKey());

        final var person = DozerMapper.parseObject(personDto, Person.class);

        final Person updatedEntity = personRepository.save(person);

        final var newPersonDto = DozerMapper.parseObject(updatedEntity, PersonDto.class);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(personDto.getKey())).withSelfRel());

        return newPersonDto;
    }

    public void delete(Long id) {

        final Person person = getPersonById(id);

        personRepository.delete(person);
    }

    private Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

}
