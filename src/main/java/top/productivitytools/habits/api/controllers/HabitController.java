package top.productivitytools.habits.api.controllers;

import java.util.List;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import top.productivitytools.habits.api.entities.Habit;
import top.productivitytools.habits.api.services.HabitService;

@Controller
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;

    @QueryMapping
    public Habit getHabit() {
        var habit = habitService.getHabitById(1);
        return habit;
    }

    @QueryMapping
    public List<Habit> getHabits() {
        return habitService.getHabits();
    }

    @MutationMapping
    public Habit createHabit(String name)
    {
        return new Habit();
    }
}
