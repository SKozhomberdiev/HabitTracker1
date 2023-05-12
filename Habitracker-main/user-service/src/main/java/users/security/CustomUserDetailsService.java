package users.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import users.entity.UserEntity;
import users.service.CustomUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomUserService customUserService;

    @Autowired
    public CustomUserDetailsService(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user=customUserService.getByEmail(email);
        return UserPrincipal.create(user);
    }
}
