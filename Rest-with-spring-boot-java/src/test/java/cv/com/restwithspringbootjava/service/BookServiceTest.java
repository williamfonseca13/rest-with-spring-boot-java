package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.MockBook;
import cv.com.restwithspringbootjava.model.Book;
import cv.com.restwithspringbootjava.repository.BookRepository;
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
class BookServiceTest {

    private MockBook input;
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        input = new MockBook();
        bookService = new BookService(bookRepository);
    }

    @Test
    void findByIdTest() throws Exception {

        final var book = input.mockEntity();
        book.setKey(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        final var result = bookService.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
    }

    @Test
    void findAllTest() {
        final var list = input.mockEntityList();

        when(bookRepository.findAll()).thenReturn(list);

        final var people = bookService.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());

        final var personOne = people.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());

        final var personFour = people.get(4);

        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertNotNull(personFour.getLinks());

        final var personSeven = people.get(7);

        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertNotNull(personSeven.getLinks());
    }

    @Test
    void createTest() {
        final var entity = input.mockEntity(1);
        entity.setKey(1L);

        Book persisted = entity;
        persisted.setKey(1L);

        final var vo = input.mockVO(1);
        vo.setKey(1L);

        when(bookRepository.save(entity)).thenReturn(persisted);

        final var result = bookService.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
    }

    @Test
    void updateTest() {

        final var entity = input.mockEntity(1);

        Book persisted = entity;
        persisted.setKey(1L);

        final var vo = input.mockVO(1);
        vo.setKey(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(bookRepository.save(entity)).thenReturn(persisted);

        final var result = bookService.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
    }

    @Test
    void deleteTest() {
        Book entity = input.mockEntity(1);
        entity.setKey(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));
        bookService.delete(1L);
    }

    @Test
    void testUpdateWithNullPerson() {

        final var exception = assertThrows(NullPointerException.class, () ->
                bookService.update(null)
        );

        String expectedMessage = "Cannot invoke \"cv.com.restwithspringbootjava.data.dto.v1.BookDto.getKey()\" because \"bookDto\" is null";
        String actualMessage = exception.getMessage();

        System.out.println(actualMessage);
        System.out.println(expectedMessage);

        assertTrue(actualMessage.contains(expectedMessage));
    }
}