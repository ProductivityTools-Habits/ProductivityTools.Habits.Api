package top.productivitytools.habits.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import top.productivitytools.habits.api.entities.Execution;

public interface ExecutionRepo extends JpaRepository<Execution, Integer> {

    List<Execution> findByHabitId(Integer habitId);

    List<Execution> findByHabitIdAndDate(Integer habitId, java.time.LocalDate date);
}