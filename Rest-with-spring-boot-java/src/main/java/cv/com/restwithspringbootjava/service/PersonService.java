package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.controller.PersonController;
import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import cv.com.restwithspringbootjava.exception.ResourceNotFoundException;
import cv.com.restwithspringbootjava.mapper.PersonMapper;
import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDto findById(Long id) {

        final Person person = getPersonById(id);

        final var personDto = PersonMapper.toDto(person);
        personDto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

        return personDto;
    }

    public List<PersonDto> findAll() {
        return personRepository.findAll().stream()
                .map(PersonMapper::toDto)
                .map(obj -> obj.add(linkTo(methodOn(PersonController.class).findById(obj.key())).withSelfRel()))
                .toList();
    }

    public PersonDto create(PersonDto personDto) {

        final var person = PersonMapper.toEntity(personDto);

        final Person entity = personRepository.save(person);

        final var newPersonDto = PersonMapper.toDto(entity);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(personDto.key())).withSelfRel());

        return newPersonDto;
    }

    public PersonDto update(PersonDto personDto) {

        final var entity = this.getPersonById(personDto.key());

        final var person = PersonMapper.partialUpdate(personDto, entity);

        final Person updatedEntity = personRepository.save(person);

        final var newPersonDto = PersonMapper.toDto(updatedEntity);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(personDto.key())).withSelfRel());

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
