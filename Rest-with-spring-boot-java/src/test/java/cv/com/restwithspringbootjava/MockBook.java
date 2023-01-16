package cv.com.restwithspringbootjava;

import cv.com.restwithspringbootjava.data.dto.v1.BookDto;
import cv.com.restwithspringbootjava.model.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockBook {
    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDto mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<BookDto> mockVOList() {
        List<BookDto> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    public Book mockEntity(Integer number) {
        Book person = new Book();
        person.setLaunchDate(LocalDateTime.now());
        person.setPrice(1.0);
        person.setAuthor("Addres Test" + number);
        person.setTitle("First Name Test" + number);
        person.setKey(number.longValue());
        return person;
    }

    public BookDto mockVO(Integer number) {
        BookDto bookDto = new BookDto();
        bookDto.setLaunchDate(LocalDateTime.now());
        bookDto.setPrice(25.0);
        bookDto.setAuthor("First Name Test" + number);
        bookDto.setKey(number.longValue());
        bookDto.setTitle("Last Name Test" + number);
        return bookDto;
    }
}
