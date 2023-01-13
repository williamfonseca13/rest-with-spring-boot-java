package cv.com.restwithspringbootjava.data.dto.v2;

import cv.com.restwithspringbootjava.model.Person;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Person} entity
 */
public record PersonDtoV2(
        Long id,
        String firstName,
        String lastName,
        String address,
        String gender,
        LocalDate birthDate
)
        implements Serializable {
}