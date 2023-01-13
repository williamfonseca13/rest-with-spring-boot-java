package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import cv.com.restwithspringbootjava.exception.ResourceNotFoundException;
import cv.com.restwithspringbootjava.mapper.PersonMapperImpl;
import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

// TODO implement tests for service

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final PersonRepository personRepository;

    private final PersonMapperImpl mapper = new PersonMapperImpl();

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDto findById(Long id) {

        final Person person = getPersonById(id);

        return mapper.toDto(person);
    }

    public List<PersonDto> findAll() {

        final var persons = personRepository.findAll();

        return persons.stream().map(mapper::toDto).toList();
    }

    public PersonDto create(PersonDto personDto) {

        final var person = mapper.toEntity(personDto);

        final Person entity = personRepository.save(person);

        return mapper.toDto(entity);
    }

    public PersonDto update(PersonDto personDto) {

        final var entity = this.getPersonById(personDto.id());

        final var person = mapper.partialUpdate(personDto, entity);

        final Person updatedEntity = personRepository.save(person);

        return mapper.toDto(updatedEntity);
    }

    public void delete(Long id) {

        final Person person = getPersonById(id);

        personRepository.delete(person);
    }

    private Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

}
