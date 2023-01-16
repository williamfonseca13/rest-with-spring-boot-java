package cv.com.restwithspringbootjava.repository;

import cv.com.restwithspringbootjava.model.Book;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {
}
