package sk.stuba.fei.uim.oop.cvicenie12.animal;

import sk.stuba.fei.uim.oop.cvicenie12.exceptions.NotFoundException;

import java.util.List;

public interface IAnimalService {
    List<Animal> getAll();
    Animal create(AnimalRequest request);
    List<Animal> getAllByName(String name);
    Animal addPersonToAnimal(long animalId, long personId);
}
