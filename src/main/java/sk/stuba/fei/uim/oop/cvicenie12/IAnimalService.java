package sk.stuba.fei.uim.oop.cvicenie12;

import java.util.List;

public interface IAnimalService {
    List<Animal> getAll();
    Animal create(AnimalRequest request);
    List<Animal> getAllByName(String name);
}
