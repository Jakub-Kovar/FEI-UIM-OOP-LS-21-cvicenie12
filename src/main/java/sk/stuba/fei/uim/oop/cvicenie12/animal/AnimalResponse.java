package sk.stuba.fei.uim.oop.cvicenie12.animal;

import lombok.Getter;
import sk.stuba.fei.uim.oop.cvicenie12.person.PersonResponse;

@Getter
public class AnimalResponse {

    private Long id;

    private String species;

    private String name;

    private PersonResponse person;

    public AnimalResponse(Animal a) {
        this.id = a.getId();
        this.species = a.getSpecies();
        this.name = a.getName();
        this.person = a.getPerson() != null ? new PersonResponse(a.getPerson()) : null;
    }
}
