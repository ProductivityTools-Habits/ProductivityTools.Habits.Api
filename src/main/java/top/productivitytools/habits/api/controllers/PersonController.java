package top.productivitytools.habits.api.controllers;

import top.productivitytools.habits.api.entities.Person;
import top.productivitytools.habits.api.services.PersonService;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    public Person getPerson() {
        var person = personService.getEmployeeById(1);
        return person;
    }
}