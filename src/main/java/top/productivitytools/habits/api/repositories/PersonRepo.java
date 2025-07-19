package top.productivitytools.habits.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import top.productivitytools.habits.api.entities.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}