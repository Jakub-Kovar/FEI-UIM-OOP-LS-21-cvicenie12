package sk.stuba.fei.uim.oop.cvicenie12.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.cvicenie12.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.cvicenie12.payment.Payment;
import sk.stuba.fei.uim.oop.cvicenie12.payment.PaymentRepository;
import sk.stuba.fei.uim.oop.cvicenie12.person.IPersonService;
import sk.stuba.fei.uim.oop.cvicenie12.person.Person;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements IAnimalService {


    private AnimalRepository repository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private IPersonService personService;

    @Autowired
    public AnimalService(AnimalRepository repository) {
        this.repository = repository;

        Animal a1 = new Animal();
        a1.setSpecies("Dog");
        a1.setName("Rex");
        this.repository.save(a1);
        Animal a2 = new Animal();
        a2.setSpecies("Cat");
        a2.setName("Felix");
        this.repository.save(a2);
    }

    @Override
    public List<Animal> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Animal create(AnimalRequest request) {
        Animal newAnimal = new Animal();
        newAnimal.setSpecies(request.getSpecies());
        newAnimal.setName(request.getName());
        return this.repository.save(newAnimal);
    }

    @Override
    public List<Animal> getAllByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public Animal addPersonToAnimal(long animalId, long personId) {
        Optional<Animal> animalOpt = this.repository.findById(animalId);
        Animal animal = animalOpt.orElseThrow(NotFoundException::new);

        Person person = this.personService.getById(personId);

        Payment payment = new Payment(animal, person, 10);

        payment = this.paymentRepository.save(payment);

        person.getPayments().add(payment);
        animal.getPayments().add(payment);

        this.personService.save(person);
        return this.repository.save(animal);
    }
}
