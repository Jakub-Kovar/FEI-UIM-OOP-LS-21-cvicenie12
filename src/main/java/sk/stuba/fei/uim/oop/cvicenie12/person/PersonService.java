package sk.stuba.fei.uim.oop.cvicenie12.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;

        this.repository.save(new Person("Tomas"));
        this.repository.save(new Person("Martin"));
        this.repository.save(new Person("Jakub"));
    }

    @Override
    public List<Person> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Person getById(long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Person save(Person p) {
        return this.repository.save(p);
    }
}
