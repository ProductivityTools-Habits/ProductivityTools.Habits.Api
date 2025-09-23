package top.productivitytools.habits.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import top.productivitytools.habits.api.entities.Execution;
import top.productivitytools.habits.api.services.ExecutionService;

@Controller
@RequiredArgsConstructor
public class ExecutionController {
    private final ExecutionService executionService;

    @QueryMapping
    public List<Execution> getExecutions() {
        return executionService.getExecutions();
    }

    @MutationMapping
    public boolean completeExecution(@Argument("id") Integer id, @Argument("date") LocalDate date) {
        var r = this.executionService.completeExecution(id, date);
        return r;
    }

    @MutationMapping
    public boolean skipExecution(@Argument("id") Integer id, @Argument("date") LocalDate date) {
        var r = this.executionService.skipExecution(id, date);
        return r;
    }
}
