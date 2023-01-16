package cv.com.restwithspringbootjava.service;

import cv.com.restwithspringbootjava.model.Person;

public class MockPerson {
    public Person mockEntity() {
        Person person = new Person();
        person.setId(null);
        person.setFirstName("William");
        person.setLastName("Fonseca");
        person.setAddress("Palmarejo");
        person.setGender("Male");
        return person;
    }
}
