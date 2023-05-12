package service_client.client;

import service_client.data.Habit;
import service_client.data.request.HabitCreation;
import service_client.result.HabitListResult;
import service_client.result.HabitResult;


import java.util.List;

public class HabitClient extends Client{
    private static final String SERVICE_PATH = "/habit-service/habits/";

    HabitClient() {
        super(SERVICE_PATH);
    }

    public Habit get(final Long id) {
        return get(id.toString(), HabitResult.class).getData();
    }

    public List<Habit> getList() {
        return get("", HabitListResult.class).getData();
    }

    public List<Habit> getListByUser(final Long userId) {
        return get("/getByUser/" + userId, HabitListResult.class).getData();
    }


    public Habit add(final HabitCreation habitCreation, final String token) {
        return post( "/add", habitCreation, HabitResult.class, token).getData();
    }

    public Habit update(final Habit habit, final String token) {
        return post("/update", habit, HabitResult.class, token).getData();
    }
}
