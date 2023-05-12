package service_client.result;

import lombok.NoArgsConstructor;
import service_client.data.Habit;

import java.util.List;

@NoArgsConstructor
public class HabitListResult extends Result<List<Habit>> {
    public HabitListResult(String message, List<Habit> data) {
        super(message, data);
    }
}

