package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void regiserNewUser(User user){
        Optional<User> userOptional = userRepo.findUserByEmail(user.getEmail());

        if (userOptional.isPresent())
        {
            throw new IllegalStateException("Данный e-mail занят");
        }
        else
        {
        userRepo.save(user);
        }
    }

    public User log_in(User user)
    {
        if(userRepo.findUserByEmail(user.getEmail()).isPresent()) {
            Optional<User> optionalUser = userRepo.findUserByEmail(user.getEmail());
            if(optionalUser.get().getPassword()==user.getPassword()) {
                return optionalUser.get();
            }
            else throw new IllegalStateException("Неверный пароль");
        }
        else throw new IllegalStateException("Такого юзера нет");
    }
}
