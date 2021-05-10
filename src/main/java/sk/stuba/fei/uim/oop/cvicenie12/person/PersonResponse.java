package sk.stuba.fei.uim.oop.cvicenie12.person;

import lombok.Getter;

@Getter
public class PersonResponse {

    private long id;

    private String name;

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
    }
}
