package sk.stuba.fei.uim.oop.cvicenie12.animal;

import lombok.Getter;
import sk.stuba.fei.uim.oop.cvicenie12.person.PersonResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AnimalResponse {

    private Long id;

    private String species;

    private String name;

    private List<PersonResponse> person;

    public AnimalResponse(Animal a) {
        this.id = a.getId();
        this.species = a.getSpecies();
        this.name = a.getName();
        this.person = a.getPayments().stream().map(payment -> new PersonResponse(payment.getPerson())).collect(Collectors.toList());
    }
}
