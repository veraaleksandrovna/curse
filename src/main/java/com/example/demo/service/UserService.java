package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    UserRepo userRepo;
    //BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public String regiserNewUser(User user){
        Optional<User> userOptional = userRepo.findUserByEmail(user.getEmail());

        if (userOptional.isPresent())
        {
            throw new IllegalStateException("Данный e-mail занят");
        }
        else
        {
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        //user.setPassword(encodedPassword);
        userRepo.save(user);
        }
        //TODO: send confirmation token
        return "redirect:/login";
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findUserByEmail(email).get();
    }


}
