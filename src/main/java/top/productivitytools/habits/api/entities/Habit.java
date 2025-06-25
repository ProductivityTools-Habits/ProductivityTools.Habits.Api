package top.productivitytools.habits.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "habits")
public class Habit {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
  

    public Habit(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
