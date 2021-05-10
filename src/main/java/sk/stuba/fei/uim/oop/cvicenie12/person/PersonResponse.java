package sk.stuba.fei.uim.oop.cvicenie12.person;

import lombok.Getter;

@Getter
public class PersonResponse {

    private long id;

    private String name;

    private Long animalId;

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.animalId = person.getAnimal() != null ? person.getAnimal().getId() : null;
    }
}
