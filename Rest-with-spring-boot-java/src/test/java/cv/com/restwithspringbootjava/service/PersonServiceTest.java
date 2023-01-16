package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.MockPerson;
import cv.com.restwithspringbootjava.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    @Disabled
    void findAllTest() {
    }

    @Test
    @Disabled
    void createTest() {
    }

    @Test
    @Disabled
    void updateTest() {
    }

    @Test
    @Disabled
    void deleteTest() {
    }


}