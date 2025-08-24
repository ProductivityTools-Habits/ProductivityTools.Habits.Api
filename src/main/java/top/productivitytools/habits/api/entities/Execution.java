package top.productivitytools.habits.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "executions")
public class Execution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "habitId")
    private Habit habit;

    @Column(name = "status")
    private boolean status;

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Habit getHabit() {
        return habit;
    }

    public boolean isStatus() {
        return status;
    }
}