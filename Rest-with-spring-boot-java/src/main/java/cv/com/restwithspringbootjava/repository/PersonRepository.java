package cv.com.restwithspringbootjava.repository;

import cv.com.restwithspringbootjava.model.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long> {
}
