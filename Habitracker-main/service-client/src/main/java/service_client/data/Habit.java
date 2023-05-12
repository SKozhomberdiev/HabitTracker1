package service_client.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Habit {

    private Long id;

    private String name;

    private String description;

    private int repetitionsPerDay;

    private int repetitionRate;

    private String measurement;

    private LocalDate startDate;

    private LocalDate endDate;
}
