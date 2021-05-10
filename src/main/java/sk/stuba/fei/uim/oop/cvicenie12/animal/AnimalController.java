package sk.stuba.fei.uim.oop.cvicenie12.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.cvicenie12.animal.AnimalRequest;
import sk.stuba.fei.uim.oop.cvicenie12.animal.AnimalResponse;
import sk.stuba.fei.uim.oop.cvicenie12.animal.IAnimalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private IAnimalService service;

    @GetMapping()
    public List<AnimalResponse> getAllAnimals() {
        return this.service.getAll().stream().map(AnimalResponse::new).collect(Collectors.toList());
//        var result = new ArrayList<AnimalResponse>();
//        for(Animal a : this.service.getAll()) {
//            result.add(new AnimalResponse(a));
//        }
//        return result;
    }

    @PostMapping()
    public ResponseEntity<AnimalResponse> addAnimal(@RequestBody AnimalRequest request) {
        return new ResponseEntity<>(new AnimalResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AnimalResponse addPersonToAnimal(@PathVariable("id") long animalId, @RequestParam("person") long personId) {
        return new AnimalResponse(this.service.addPersonToAnimal(animalId, personId));
    }

    @GetMapping("/{name}")
    public List<AnimalResponse> getAllAnimalsByName(@PathVariable("name") String name) {
        return this.service.getAllByName(name).stream().map(AnimalResponse::new).collect(Collectors.toList());
    }
}
