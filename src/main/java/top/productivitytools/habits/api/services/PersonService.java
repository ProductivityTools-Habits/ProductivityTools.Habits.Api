package top.productivitytools.habits.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.productivitytools.habits.api.entities.Person;
import top.productivitytools.habits.api.repositories.PersonRepo;

@Service
@RequiredArgsConstructor
@Slf4j
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
