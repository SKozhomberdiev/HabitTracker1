package habits.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import service_client.data.Habit;
import users.entity.UserEntity;


import java.time.LocalDate;
import java.util.Map;

@Entity
@Table
@Data
@EqualsAndHashCode(of={"id"})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HabitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int repetitionsPerDay;

    private int repetitionRate;

    private String measurement;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity profile;

    @ElementCollection
    private Map<LocalDate,Integer> habitData;

    public Habit toDto() {
        return new Habit(id, name, description, repetitionsPerDay, repetitionRate, measurement, startDate, endDate);
    }


}
