package users.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.entity.UserEntity;
import users.service.AuthService;
import users.service.CustomUserService;

@RestController
@RequestMapping("user")
public class UserController {

    private final CustomUserService customUserService;

    private final AuthService authService;

    public UserController(CustomUserService customUserService, AuthService authService) {
        this.customUserService = customUserService;
        this.authService = authService;
    }

    @PostMapping("/activate/changePassword")
    public UserEntity activateChangePassword(@RequestHeader(name="Authorization") String authorizationHeader){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        return customUserService.activeChangePassword(user);
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<?> activeChangePassword(@PathVariable String code){
        UserEntity user=customUserService.getByActivationCode(code);
        return authService.authenticate(user);
    }

    @PostMapping("/changePassword")
    public UserEntity changePassword(@RequestBody String newPassword,@RequestHeader(name="Authorization") String authorizationHeader){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        return customUserService.changePassword(newPassword,user);
    }
}
