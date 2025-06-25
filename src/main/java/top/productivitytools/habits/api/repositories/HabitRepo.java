package top.productivitytools.habits.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import top.productivitytools.habits.api.entities.Habit;

public interface HabitRepo extends JpaRepository<Habit, Integer> {

}