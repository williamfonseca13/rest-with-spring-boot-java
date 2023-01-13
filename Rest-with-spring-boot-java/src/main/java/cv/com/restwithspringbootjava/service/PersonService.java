package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.exception.ResourceNotFoundException;
import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public List<Person> findAll() {

        logger.info("Finding all!");

        return personRepository.findAll();
    }

    public Person create(Person person) {

        logger.info("Creating a person!");

        return personRepository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating a person!");

        final var entity = findById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id) {

        logger.info("Deleting a person!");

        final var entity = findById(id);

        personRepository.delete(entity);
    }

}
