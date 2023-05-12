package service_client.client;


import service_client.data.request.SubmitRequest;
import service_client.result.HabitResult;
import service_client.result.HabitResultResponse;




public class TrackerClient extends Client{
    private static final String SERVICE_PATH = "/tracking-service";

    public TrackerClient() {
        super(SERVICE_PATH);
    }

    public HabitResult submit(final SubmitRequest request, final String token) {
        return post("/submit", request, HabitResultResponse.class, token).getData();
    }
}
