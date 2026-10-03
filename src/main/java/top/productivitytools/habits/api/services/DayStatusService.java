package top.productivitytools.habits.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.productivitytools.habits.api.entities.DayStatus;
import top.productivitytools.habits.api.repositories.DayStatusRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class DayStatusService {

    private final DayStatusRepo dayStatusRepo;

    @Transactional(readOnly = true)
    public List<DayStatus> getDayStatuses() {
        try {
            return dayStatusRepo.findAll();
        } catch (Exception e) {
            log.error("Error while getting day statuses", e);
            return java.util.Collections.emptyList();
        }
    }

    public boolean skipDay(LocalDate date, String reason) {
        return setStatus(date, "Skipped", reason);
    }

    public boolean failDay(LocalDate date, String reason) {
        return setStatus(date, "Failed", reason);
    }

    @Transactional
    public boolean resetDay(LocalDate date) {
        try {
            dayStatusRepo.findByDate(date).ifPresent(dayStatusRepo::delete);
            return true;
        } catch (Exception e) {
            log.error("Error while resetting day status", e);
            return false;
        }
    }

    private boolean setStatus(LocalDate date, String status, String reason) {
        try {
            var dayStatus = dayStatusRepo.findByDate(date).orElseGet(DayStatus::new);
            dayStatus.setDate(date);
            dayStatus.setStatus(status);
            dayStatus.setReason(reason);
            dayStatusRepo.save(dayStatus);
            return true;
        } catch (Exception e) {
            log.error("Error while setting day status", e);
            return false;
        }
    }
}
