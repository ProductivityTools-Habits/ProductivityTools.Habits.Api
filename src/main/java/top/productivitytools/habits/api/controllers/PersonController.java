package top.productivitytools.habits.api.controllers;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import top.productivitytools.habits.api.entities.Person;
import top.productivitytools.habits.api.services.PersonService;

@Controller
@RequiredArgsConstructor
public class PersonController {
    
    private final PersonService personService;

    @QueryMapping
    public Person getPerson() {
        var person = personService.getEmployeeById(1);
        return person;
    }
}