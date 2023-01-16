package cv.com.restwithspringbootjava.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import cv.com.restwithspringbootjava.model.Person;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Person} entity
 */
@JsonPropertyOrder({"key", "firstName", "lastName", "address", "gender"})
public class PersonDto extends RepresentationModel<PersonDto> implements Serializable {

    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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