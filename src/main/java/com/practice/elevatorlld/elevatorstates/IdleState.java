package com.practice.elevatorlld.elevatorstates;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;

public class IdleState extends ElevatorState{
    public IdleState(Elevator elevator)
    {
        super(elevator);
    }
    @Override
    public void Move() {
       // System.out.println("Entered in idle state Move");
        Elevator elevator = getElevator();
        if(!elevator.getUpMinPQ().isEmpty())
        {
            elevator.setCurrentElevatorState(new MovingUpState(elevator));
        }
        else if(!elevator.getDownMaxPQ().isEmpty())
        {
            elevator.setCurrentElevatorState(new MovingDownState(elevator));
        }
       // System.out.println("Entered out of idle state Move");
    }

    @Override
    public void addRequest(Request request) {
        Elevator elevator = getElevator();
        if(request.getFloorNumber() > elevator.getCurrentFloor())
        {
            elevator.getUpMinPQ().offer(request.getFloorNumber());
        }
        else if(request.getFloorNumber() < elevator.getCurrentFloor())
        {
            elevator.getDownMaxPQ().offer(request.getFloorNumber());
        }


    }
}
