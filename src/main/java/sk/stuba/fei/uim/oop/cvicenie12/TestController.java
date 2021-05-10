package sk.stuba.fei.uim.oop.cvicenie12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class TestController {

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
    public AnimalResponse addAnimal(@RequestBody AnimalRequest request) {
        return new AnimalResponse(this.service.create(request));
    }

    @GetMapping("/{name}")
    public List<AnimalResponse> getAllAnimalsByName(@PathVariable("name") String name) {
        return this.service.getAllByName(name).stream().map(AnimalResponse::new).collect(Collectors.toList());
    }
}
