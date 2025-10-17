package top.productivitytools.habits.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.productivitytools.habits.api.entities.Habit;
import top.productivitytools.habits.api.repositories.HabitRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class HabitService {
    private final HabitRepo habitRepo;

    public Habit getHabitById(int id) {
        Optional<Habit> habit = habitRepo.findById(id);
        if (habit.isPresent()) {
            return habit.get();
        }
        return null;
    }

    public List<Habit> getHabits() {
        return habitRepo.findAll();
    }

    public boolean addHabit(Habit habit)
    {
        try{
            his.habitRepo.save(habit);
            return true;
        }
        catch(Exception e)
        {
            log.error("Error adding habit: {}", e.getMessage());
            return false;
        } 
    }

    public boolean deleteHabit(int id)
    {
        try{
        this.habitRepo.deleteById(id);
        return true;
        }
        catch(Exception e)
        {
            return false;
        } 
    }   
}
