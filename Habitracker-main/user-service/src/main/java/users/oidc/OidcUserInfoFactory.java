package users.oidc;


import com.intership.app.habittracker.exception.OidcAuthenticationProcessingException;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import users.entity.AuthProvider;

import java.util.Map;

public class OidcUserInfoFactory {
    public static OidcUserInfo getOidcUserInfo(String registrationId, Map<String, Object> claims) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOIdcUserInfo(claims);
        }
        else {
            throw new OidcAuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
