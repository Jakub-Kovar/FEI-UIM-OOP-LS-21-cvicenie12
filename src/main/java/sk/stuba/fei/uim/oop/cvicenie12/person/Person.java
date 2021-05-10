package sk.stuba.fei.uim.oop.cvicenie12.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.cvicenie12.animal.Animal;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Setter
    @OneToOne
    private Animal animal;

    public Person(String name) {
        this.name = name;
    }
}
