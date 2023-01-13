package cv.com.restwithspringbootjava.data.dto.v1;

import cv.com.restwithspringbootjava.model.Person;

import java.io.Serializable;

/**
 * A DTO for the {@link Person} entity
 */
public record PersonDto(Long id, String firstName, String lastName, String address,
                        String gender) implements Serializable {
}