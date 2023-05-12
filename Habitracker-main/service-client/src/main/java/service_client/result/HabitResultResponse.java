package service_client.result;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HabitResultResponse extends Result<HabitResult> {
    public HabitResultResponse(String message, HabitResult data) {
        super(message, data);
    }
}

