package sk.stuba.fei.uim.oop.cvicenie12.animal;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.cvicenie12.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String species;

    private String name;

    @OneToMany
    private List<Person> person = new ArrayList<>();
}
