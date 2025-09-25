package com.practice.elevatorlld;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;
import com.practice.elevatorlld.models.RequestType;
import com.practice.elevatorlld.services.ElevatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ElevatorLldApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElevatorLldApplication.class, args);
    }

}
