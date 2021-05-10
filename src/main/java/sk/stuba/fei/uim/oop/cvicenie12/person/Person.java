package sk.stuba.fei.uim.oop.cvicenie12.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.cvicenie12.animal.Animal;
import sk.stuba.fei.uim.oop.cvicenie12.payment.Payment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Setter
    @OneToMany
    private List<Payment> payments = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }
}
