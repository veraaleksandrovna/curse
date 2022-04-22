package com.example.demo;

import com.example.demo.domain.FashUser;
import com.example.demo.service.ClientService;
import com.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {
	static ClientService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
