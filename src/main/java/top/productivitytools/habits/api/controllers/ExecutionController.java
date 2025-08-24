package top.productivitytools.habits.api.controllers;

import java.util.List;
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
}
