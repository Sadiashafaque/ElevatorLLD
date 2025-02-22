package com.practice.elevatorlld.controllers;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.services.ElevatorService;
import com.practice.elevatorlld.strategies.liftselectionstrategy.LiftSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Elevatorcontroller {
    private List<Elevator> elevators = new ArrayList<>();
    ElevatorService elevatorService;
    LiftSelectionStrategy liftSelectionStrategy;
    public void requestForLift(int floor, Direction direction)
    {
       Elevator elevator = liftSelectionStrategy.SelectLift(elevators,floor);
       elevatorService.requestForLift(elevator, direction, floor);
    }
//    public void moveElevator(Elevator elevator, int soureFloor, int destinationFloor)
//    {
//        elevatorService.moveElevator(elevator, soureFloor, destinationFloor);
//    }
}
