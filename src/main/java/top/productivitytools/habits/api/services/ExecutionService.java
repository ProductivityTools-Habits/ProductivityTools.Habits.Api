package top.productivitytools.habits.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.productivitytools.habits.api.entities.Execution;
import top.productivitytools.habits.api.repositories.ExecutionRepo;
import top.productivitytools.habits.api.repositories.HabitRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutionService {

    private final ExecutionRepo executionRepo;
    private final HabitRepo habitRepo;

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

    public boolean completeExecution(int id, LocalDate date) {
        var r = this.setStatus(id, date, "Completed");
        return r;
    }

    public boolean skipExecution(int id, LocalDate date) {
        var r = this.setStatus(id, date, "Skipped");
        return r;
    }
    
    public boolean resetExecution(int id, LocalDate date){
        var r=this.setStatus(id, date, "Waiting");
        return r;
    }

    public boolean failExecution(int id, LocalDate date){
        var r=this.setStatus(id, date, "Failed");
        return r;
    }

    private boolean setStatus(int id, LocalDate date, String status) {
        try {
            var recordExists = executionRepo.findByHabitIdAndDate(id, date);            
            if (recordExists.size() == 1) {
                var record=recordExists.get(0);
                record.setStatus(status);
                executionRepo.save(record);
                return true;
            } else {
                var habit = habitRepo.getReferenceById(id);
                Execution execution = new Execution();
                execution.setStatus(status);
                execution.setDate(date);
                execution.setHabit(habit);
                executionRepo.save(execution);
                return true;
            }
        } catch (Exception e) {
            log.error("Error while completing execution", e);
            return false;
        }
    }

}
