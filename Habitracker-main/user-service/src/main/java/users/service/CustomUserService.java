package users.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service_client.security.jwt.JwtService;
import users.entity.EmailDetails;
import users.entity.UserEntity;
import users.repository.UserRepository;

import java.util.UUID;

@Service
public class CustomUserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    private final JwtService jwtService;

    @Autowired
    public CustomUserService(UserRepository userRepository, EmailService emailService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.jwtService = jwtService;
    }

    public UserEntity getByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    public UserEntity getByActivationCode(String code){
        return userRepository.findByActivationCode(code);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public boolean activateUser(String code) {
        UserEntity user = getByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        user.setEmailVerified(true);
        save(user);

        return true;
    }

    public UserEntity activeChangePassword(UserEntity user) {
        if(user.getEmailVerified()){
            user.setActivationCode(UUID.randomUUID().toString());
            UserEntity result = save(user);

            String message = String.format(
                    "Hello, %s! \n" +
                            "To change password visit next link: http://localhost:8080/user/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            EmailDetails emailDetails=new EmailDetails();
            emailDetails.setRecipient(result.getEmail());
            emailDetails.setSubject("Activation code");
            emailDetails.setMsgBody(message);

            emailService.sendSimpleMail(emailDetails);

            return result;
        }
        else return user;
    }

    public UserEntity getFromAuthentication(String authorizationHeader){
        String jwt = authorizationHeader.substring(7);
        String email=jwtService.extractEmail(jwt);
        return getByEmail(email);
    }

    public UserEntity changePassword(String newPassword, UserEntity user) {
        user.setPassword(newPassword);
        user.setChangablePassword(false);
        return userRepository.save(user);
    }
}
