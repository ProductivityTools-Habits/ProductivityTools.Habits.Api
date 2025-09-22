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
    @JoinColumn(name = "habitid")
    private Habit habit;

    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Habit getHabit() {
        return habit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHabit(Habit habit)
    {
        this.habit=habit;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}