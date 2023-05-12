package service_client.data.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class HabitCreation {
    private String name;

    private String description;

    private int repetitionsPerDay;

    private int repetitionRate;

    private String measurement;

    private LocalDate startDate;

    private LocalDate endDate;
}
