package top.productivitytools.habits.api.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import top.productivitytools.habits.api.entities.DayStatus;

public interface DayStatusRepo extends JpaRepository<DayStatus, Integer> {

    Optional<DayStatus> findByDate(LocalDate date);
}
