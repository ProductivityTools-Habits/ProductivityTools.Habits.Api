package top.productivitytools.habits.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import top.productivitytools.habits.api.entities.Execution;

public interface ExecutionRepo extends JpaRepository<Execution, Integer> {

}