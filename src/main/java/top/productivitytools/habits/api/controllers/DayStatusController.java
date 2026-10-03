package top.productivitytools.habits.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import top.productivitytools.habits.api.entities.DayStatus;
import top.productivitytools.habits.api.services.DayStatusService;

@Controller
@RequiredArgsConstructor
public class DayStatusController {
    private final DayStatusService dayStatusService;

    @QueryMapping
    public List<DayStatus> getDayStatuses() {
        return dayStatusService.getDayStatuses();
    }

    @MutationMapping
    public boolean skipDay(@Argument("date") LocalDate date, @Argument("reason") String reason) {
        return dayStatusService.skipDay(date, reason);
    }

    @MutationMapping
    public boolean failDay(@Argument("date") LocalDate date, @Argument("reason") String reason) {
        return dayStatusService.failDay(date, reason);
    }

    @MutationMapping
    public boolean resetDay(@Argument("date") LocalDate date) {
        return dayStatusService.resetDay(date);
    }
}
