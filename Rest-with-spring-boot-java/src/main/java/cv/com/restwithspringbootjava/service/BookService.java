package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.controller.PersonController;
import cv.com.restwithspringbootjava.data.dto.v1.BookDto;
import cv.com.restwithspringbootjava.exception.ResourceNotFoundException;
import cv.com.restwithspringbootjava.mapper.DozerMapper;
import cv.com.restwithspringbootjava.model.Book;
import cv.com.restwithspringbootjava.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto findById(Long id) {

        final var person = getPersonById(id);

        final var personDto = DozerMapper.parseObject(person, BookDto.class);
        personDto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

        return personDto;
    }

    public List<BookDto> findAll() {
        final var books = bookRepository.findAll();
        return DozerMapper.parseListObjects(books, BookDto.class).stream()
                .map(obj -> obj.add(linkTo(methodOn(PersonController.class).findById(obj.getKey())).withSelfRel()))
                .toList();
    }

    public BookDto create(BookDto bookDto) {

        final var book = DozerMapper.parseObject(bookDto, Book.class);

        final var savedBook = bookRepository.save(book);

        final var newPersonDto = DozerMapper.parseObject(savedBook, BookDto.class);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(bookDto.getKey())).withSelfRel());

        return newPersonDto;
    }

    public BookDto update(BookDto bookDto) {

        Objects.requireNonNull("It is not allowed to persist a null object!");

        final var entity = this.getPersonById(bookDto.getKey());

        final var book = DozerMapper.parseObject(bookDto, Book.class);

        final var updatedEntity = bookRepository.save(book);

        final var newBookDto = DozerMapper.parseObject(updatedEntity, BookDto.class);
        newBookDto.add(linkTo(methodOn(PersonController.class).findById(bookDto.getKey())).withSelfRel());

        return newBookDto;
    }

    public void delete(Long id) {

        final var book = getPersonById(id);

        bookRepository.delete(book);
    }

    private Book getPersonById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

}
