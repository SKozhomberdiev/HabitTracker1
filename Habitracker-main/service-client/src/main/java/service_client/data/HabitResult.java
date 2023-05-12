package service_client.data;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HabitResult {
    private final Status status;
    private final String text;

    public static HabitResult SuccessResult(final String text) {
        return new HabitResult(Status.SUCCESS, text);
    }
    public static HabitResult FailResult(final String text) {
        return new HabitResult(Status.FAIL, text);
    }
    public static HabitResult CompileErrorResult(final String text) {
        return new HabitResult(Status.COMPILE_ERROR, text);
    }

    public enum Status {
        SUCCESS,
        FAIL,
        COMPILE_ERROR
    }


}
