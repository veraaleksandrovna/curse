package com.example.demo.api.registration;


import com.example.demo.domain.User;
import com.example.demo.domain.roles.UserRole;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request){
        boolean IsValidEmail = emailValidator.test(request.getEmail());

        if(!IsValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        return userService.regiserNewUser(new User(request.getUsername(), request.getEmail(), request.getPassword(), UserRole.USER));
    }
}
