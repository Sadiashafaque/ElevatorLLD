package com.practice.elevatorlld.elevatorstates;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;
import com.practice.elevatorlld.models.RequestType;

public class MovingDownState extends ElevatorState {
    public MovingDownState(Elevator elevator)
    {
        super(elevator);
    }

    @Override
    public void addRequest(Request request) {
        Elevator elevator = getElevator();
        if(request.getRequestType() == RequestType.EXTERNAL) {
            if (request.getDirection() == Direction.DOWN && elevator.getCurrentFloor() > request.getFloorNumber()) {
                elevator.getDownMaxPQ().offer(request.getFloorNumber());
            } else if (request.getDirection() == Direction.UP) {
                elevator.getUpMinPQ().offer(request.getFloorNumber());
            } else if (request.getDirection() == Direction.DOWN && elevator.getCurrentFloor() < request.getFloorNumber()) {
                elevator.getPendingJobs().add(request.getFloorNumber());
            }
            return;
        }
        if(request.getFloorNumber() < elevator.getCurrentFloor())
        {
            elevator.getDownMaxPQ().offer(request.getFloorNumber());
        }
        else
        {
            elevator.getUpMinPQ().offer(request.getFloorNumber());
        }
    }
    @Override
    public void Move()
    {
        System.out.println("Entered in moving down state Move " + getElevator().getId());
        Elevator elevator = getElevator();
        if(!elevator.getDownMaxPQ().isEmpty())
        {
            int targetFloor = elevator.getDownMaxPQ().peek();
            elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
            if(elevator.getCurrentFloor() == targetFloor)
            {
                System.out.println("Elevator " + elevator.getId() + " stopped at floor " + targetFloor);
                elevator.getDownMaxPQ().poll();
            }
        }
        if(elevator.getDownMaxPQ().isEmpty())
        {
            elevator.setCurrentElevatorState(new IdleState(elevator));
        }
        System.out.println("Entered out of moving down state Move with elevator " + getElevator().getId());
    }
}

