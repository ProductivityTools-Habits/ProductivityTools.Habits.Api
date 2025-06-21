package top.productivitytools.habits.api.controllers;

<<<<<<< HEAD
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import top.productivitytools.habits.api.entities.Person;
import top.productivitytools.habits.api.services.PersonService;
=======
import top.productivitytools.habits.api.entities.Person;
import top.productivitytools.habits.api.services.PersonService;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
>>>>>>> b90f6e630cde12c656feae9d2cdd840810a4d422

@Controller
@RequiredArgsConstructor
public class PersonController {
<<<<<<< HEAD
    
    private final PersonService personService;

    @QueryMapping
=======
    private final PersonService personService;

>>>>>>> b90f6e630cde12c656feae9d2cdd840810a4d422
    public Person getPerson() {
        var person = personService.getEmployeeById(1);
        return person;
    }
}