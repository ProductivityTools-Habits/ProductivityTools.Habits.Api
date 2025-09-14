package top.productivitytools.habits.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.productivitytools.habits.api.entities.Execution;
import top.productivitytools.habits.api.repositories.ExecutionRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutionService {

    private final ExecutionRepo executionRepo;

    @Transactional(readOnly = true)
    public List<Execution> getExecutions() {
        try {
            var result = executionRepo.findAll();
            return result;
        } catch (Exception e) {
            log.error("Error while getting executions", e);
            return java.util.Collections.emptyList();
        }
    }

    public boolean completeExecution(int id) {
        try {
            Execution element=executionRepo.getReferenceById(id);
            element.setStatus("Completed");
            executionRepo.save(element);
            return true;
        } catch (Exception e) {
            log.error("Error while completing execution", e);
            return false;
        }
    }

}
