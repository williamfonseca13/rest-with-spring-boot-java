package cv.com.restwithspringbootjava.mapper;

import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import cv.com.restwithspringbootjava.model.Person;

public final class PersonMapper {
    public static Person toEntity(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.key());
        person.setFirstName(personDto.firstName());
        person.setLastName(personDto.lastName());
        person.setAddress(personDto.address());
        person.setGender(personDto.gender());
        return person;
    }

    public static PersonDto toDto(Person person) {
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAddress(),
                person.getGender()
        );
    }

    public static Person partialUpdate(PersonDto personDto, Person person) {

        if (personDto.key() != null)
            person.setId(personDto.key());

        if (personDto.firstName() != null)
            person.setFirstName(personDto.firstName());

        if (personDto.lastName() != null)
            person.setLastName(personDto.lastName());

        if (personDto.address() != null)
            person.setAddress(personDto.address());

        if (personDto.gender() != null)
            person.setGender(personDto.gender());

        return person;
    }
}