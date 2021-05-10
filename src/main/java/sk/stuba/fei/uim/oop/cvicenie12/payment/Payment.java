package sk.stuba.fei.uim.oop.cvicenie12.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.cvicenie12.animal.Animal;
import sk.stuba.fei.uim.oop.cvicenie12.person.Person;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Person person;

    private int payment;

    public Payment(Animal animal, Person person, int payment) {
        this.animal = animal;
        this.person = person;
        this.payment = payment;
    }
}
