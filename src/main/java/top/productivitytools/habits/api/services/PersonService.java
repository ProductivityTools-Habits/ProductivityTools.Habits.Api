package top.productivitytools.habits.api.services;

import java.util.List;

import top.productivitytools.habits.api.entities.Person;

public class PersonService {
      private final PersonRepo personRepo;

    public List<Person> getAllEmployees() {
        return personRepo.findAll();
    }

    public Person getEmployeeById(Integer id) {
        Optional<Person> optionalEmployee = personRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        log.info("Employee with id: {} doesn't exist", id);
        return null;
    }
}
