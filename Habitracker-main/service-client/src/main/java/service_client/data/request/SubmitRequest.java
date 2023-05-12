package service_client.data.request;

import lombok.Data;

@Data
public class SubmitRequest{
    private final Long habitId;
    private final String code;

}
