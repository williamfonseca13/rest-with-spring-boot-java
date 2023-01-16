package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.controller.PersonController;
import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import cv.com.restwithspringbootjava.exception.ResourceNotFoundException;
import cv.com.restwithspringbootjava.model.Book;
import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@Service
public class BookService {
   /* private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public PersonDto findById(Long id) {

        final Book book = getBookById(id);

        final var personDto = PersonMapper.toDto(book);
        personDto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

        return personDto;
    }

    public List<PersonDto> findAll() {
        return bookRepository.findAll().stream()
                .map(PersonMapper::toDto)
                .map(obj -> obj.add(linkTo(methodOn(PersonController.class).findById(obj.key())).withSelfRel()))
                .toList();
    }

    public PersonDto create(PersonDto personDto) {

        final var person = PersonMapper.toEntity(personDto);

        final Person entity = bookRepository.save(person);

        final var newPersonDto = PersonMapper.toDto(entity);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(personDto.key())).withSelfRel());

        return newPersonDto;
    }

    public PersonDto update(PersonDto personDto) {

        final Book book = getBookById(personDto.key());

        final var person = PersonMapper.partialUpdate(personDto, book);

        final Person updatedEntity = bookRepository.save(person);

        final var newPersonDto = PersonMapper.toDto(updatedEntity);
        newPersonDto.add(linkTo(methodOn(PersonController.class).findById(personDto.key())).withSelfRel());

        return newPersonDto;
    }

    public void delete(Long id) {

        final Book book = getBookById(id);

        bookRepository.delete(book);
    }

    private Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }*/

}
