package cv.com.restwithspringbootjava.dto;

import cv.com.restwithspringbootjava.model.Person;

import java.io.Serializable;

/**
 * A DTO for the {@link Person} entity
 */
public record PersonDto(Long id, String firstName, String lastName, String address,
                        String gender) implements Serializable {
}