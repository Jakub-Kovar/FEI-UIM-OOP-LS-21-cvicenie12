package sk.stuba.fei.uim.oop.cvicenie12.animal;

import lombok.Getter;

@Getter
public class AnimalResponse {

    private Long id;

    private String species;

    private String name;

    private Long person;

    public AnimalResponse(Animal a) {
        this.id = a.getId();
        this.species = a.getSpecies();
        this.name = a.getName();
        this.person = a.getPerson() == null ? null : a.getPerson().getId();
//        if(a.getPerson() == null) {
//            this.person = null;
//        } else {
//            this.person = a.getPerson().getId();
//        }
    }
}
