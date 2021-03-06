package sk.stuba.fei.uim.oop.cvicenie12.person;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();
    Person getById(long id);
    Person save(Person p);
}
