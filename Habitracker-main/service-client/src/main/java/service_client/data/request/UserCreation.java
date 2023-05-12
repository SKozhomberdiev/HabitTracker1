package service_client.data.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserCreation {
    public String email;
    public String username;
    public String password;

}
