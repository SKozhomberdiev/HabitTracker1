package service_client.data;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
    private Long id;

    private String username;


    private String email;

    private UserRole group;

}
