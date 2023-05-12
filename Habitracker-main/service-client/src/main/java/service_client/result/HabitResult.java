package service_client.result;

import lombok.NoArgsConstructor;
import service_client.data.Habit;

@NoArgsConstructor
public class HabitResult extends Result<Habit> {
    public HabitResult(String message, Habit data) {
        super(message, data);
    }
}


