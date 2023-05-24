package me.oleniuk.learn.hibernate_listener_test;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final EntityManager entityManager;

    private final PersonRepository personRepository;

    private final CarRepository carRepository;

    @PostMapping
    public void createPerson(){
        Person person = new Person();
        person.setName("Person " + System.currentTimeMillis());
        person.setCars(Set.of(new Car().setPlate("DDYO-1111"), new Car().setPlate("DDYO-1112")));
        carRepository.saveAll(person.getCars());
        personRepository.save(person);
    }


    @GetMapping
    public Iterable<Person> getPersons(){
        return personRepository.findAll();
    }


}
