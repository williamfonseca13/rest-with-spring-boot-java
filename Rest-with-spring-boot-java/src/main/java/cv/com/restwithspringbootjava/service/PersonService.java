package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {

        logger.info("Finding one person!");

        final var person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("William");
        person.setLastName("Fonseca");
        person.setAddress("Cabo Verde - Santiago - Praia - Palmarejo");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        final var people = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            final var person = new Person();
            person.setId(counter.incrementAndGet());
            person.setFirstName("William " + i);
            person.setLastName("Fonseca " + i);
            person.setAddress("Cabo Verde - Santiago - Praia - Palmarejo " + i);
            person.setGender("Male " + i);
            people.add(person);
        }
        return people;
    }


}
