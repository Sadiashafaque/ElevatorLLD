package com.practice.elevatorlld.controllers;

import com.practice.elevatorlld.models.Request;
import com.practice.elevatorlld.services.ElevatorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ElevatorController {
    ElevatorService elevatorService;

    public void requestForLift(Request request)
    {
       elevatorService.requestForLift(request);
    }

    public void start()
    {
        elevatorService.start();
    }

}
