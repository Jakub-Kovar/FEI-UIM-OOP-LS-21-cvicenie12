package sk.stuba.fei.uim.oop.cvicenie12.animal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAll();

    List<Animal> findByName(String name);
}
