package top.productivitytools.habits.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public boolean addHabit(Habit habit)
    {
        try{
            // If id is null or 0, treat as new entity
            if (habit.getId() == null || habit.getId() == 0) {
                // Create a new habit without an id to ensure JPA treats it as new
                Habit newHabit = new Habit(habit.getName());
                this.habitRepo.save(newHabit);
            } else {
                // For existing habits, check if it exists first
                Optional<Habit> existingHabit = habitRepo.findById(habit.getId());
                if (existingHabit.isPresent()) {
                    // Update existing habit
                    Habit existing = existingHabit.get();
                    existing.setName(habit.getName());
                    this.habitRepo.save(existing);
                } else {
                    // ID provided but doesn't exist - treat as new by creating without id
                    Habit newHabit = new Habit(habit.getName());
                    this.habitRepo.save(newHabit);
                }
            }
            return true;
        }
        catch(Exception e)
        {
            log.error("Error adding habit: {}", e.getMessage(), e);
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
