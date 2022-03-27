package com.example.demo.api.registration;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        //TODO:validate email
        return true;
    }
}
