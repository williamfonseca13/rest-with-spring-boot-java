package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.MockPerson;
import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// TODO improve this tests

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    private MockPerson input;
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        input = new MockPerson();
        personService = new PersonService(personRepository);
    }

    @Test
    void findByIdTest() throws Exception {

        final var person = input.mockEntity();
        person.setKey(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        final var result = personService.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains(""));
        assertEquals("Male", result.getGender());
        assertEquals("Addres Test0", result.getAddress());
        assertEquals("First Name Test0", result.getFirstName());
        assertEquals("Last Name Test0", result.getLastName());
    }

    @Test
    void findAllTest() {
        final var list = input.mockEntityList();

        when(personRepository.findAll()).thenReturn(list);

        final var people = personService.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());

        final var personOne = people.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());
        assertEquals("Addres Test1", personOne.getAddress());
        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Female", personOne.getGender());

        final var personFour = people.get(4);

        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertNotNull(personFour.getLinks());
        assertEquals("Addres Test4", personFour.getAddress());
        assertEquals("First Name Test4", personFour.getFirstName());
        assertEquals("Last Name Test4", personFour.getLastName());
        assertEquals("Male", personFour.getGender());

        final var personSeven = people.get(7);

        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertNotNull(personSeven.getLinks());
        assertEquals("Addres Test7", personSeven.getAddress());
        assertEquals("First Name Test7", personSeven.getFirstName());
        assertEquals("Last Name Test7", personSeven.getLastName());
        assertEquals("Female", personSeven.getGender());
    }

    @Test
    void createTest() {
        final var entity = input.mockEntity(1);
        entity.setKey(1L);

        Person persisted = entity;
        persisted.setKey(1L);

        final var vo = input.mockVO(1);
        vo.setKey(1L);

        when(personRepository.save(entity)).thenReturn(persisted);

        final var result = personService.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void updateTest() {
        final var entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setKey(1L);

        final var vo = input.mockVO(1);
        vo.setKey(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(personRepository.save(entity)).thenReturn(persisted);

        final var result = personService.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void deleteTest() {
        Person entity = input.mockEntity(1);
        entity.setKey(1L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));
        personService.delete(1L);
    }

    @Test
    void testUpdateWithNullPerson() {

        final var exception = assertThrows(NullPointerException.class, () ->
                personService.update(null)
        );

        String expectedMessage = "Cannot invoke \"cv.com.restwithspringbootjava.data.dto.v1.PersonDto.getKey()\" because \"personDto\" is null";
        String actualMessage = exception.getMessage();

        System.out.println(actualMessage);
        System.out.println(expectedMessage);

        assertTrue(actualMessage.contains(expectedMessage));
    }
}