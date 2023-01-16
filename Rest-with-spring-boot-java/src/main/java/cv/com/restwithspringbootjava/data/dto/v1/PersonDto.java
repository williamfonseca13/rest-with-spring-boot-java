package cv.com.restwithspringbootjava.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import cv.com.restwithspringbootjava.model.Person;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Person} entity
 */
@JsonPropertyOrder({"key","firstName","lastName","address","gender"})
public class PersonDto extends RepresentationModel<PersonDto> implements Serializable {

    private final Long key;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String gender;

    public PersonDto(
            Long key,
            String firstName,
            String lastName,
            String address,
            String gender
    ) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Long key() {
        return key;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String address() {
        return address;
    }

    public String gender() {
        return gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PersonDto) obj;
        return Objects.equals(this.key, that.key) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, address, gender);
    }

    @Override
    public String toString() {
        return "PersonDto[" +
                "key=" + key + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "address=" + address + ", " +
                "gender=" + gender + ']';
    }

}