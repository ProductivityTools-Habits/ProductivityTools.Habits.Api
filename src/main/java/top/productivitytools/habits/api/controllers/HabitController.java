package top.productivitytools.habits.api.controllers;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import top.productivitytools.habits.api.entities.HabitInput;
import top.productivitytools.habits.api.entities.Habit;
import top.productivitytools.habits.api.services.HabitService;

@Controller
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;

    @QueryMapping
    public Habit getHabit(@Argument("id") Integer id) {
        Habit habit = habitService.getHabitById(id);
        return habit;
    }

    @QueryMapping
    public List<Habit> getHabits() {
        return habitService.getHabits();
    }

    @MutationMapping
    public boolean createHabit(@Argument("habitInput") HabitInput createHabitInput) 
    {
        Habit habit=new Habit(createHabitInput.name());
        boolean result=this.habitService.addHabit(habit);
        return result;
    }

    @MutationMapping
    public boolean saveHabit(@Argument("habitInput") HabitInput createHabitInput) 
    {
        Habit habit=new Habit(createHabitInput.id(), createHabitInput.name());
        boolean result=this.habitService.addHabit(habit);
        return result;
    }
}
