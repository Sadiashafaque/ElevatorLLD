package com.practice.elevatorlld.elevatorstates;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;
import com.practice.elevatorlld.models.RequestType;

public class MovingUpState extends ElevatorState {
    public MovingUpState(Elevator elevator)
    {
        super(elevator);
    }

    @Override
    public void addRequest(Request request) {
        Elevator elevator = getElevator();
        if(request.getRequestType() == RequestType.EXTERNAL) {
            if (request.getDirection() == Direction.UP && elevator.getCurrentFloor() < request.getFloorNumber()) {
                elevator.getUpMinPQ().offer(request.getFloorNumber());
            } else if (request.getDirection() == Direction.DOWN) {
                elevator.getDownMaxPQ().offer(request.getFloorNumber());
            } else if (request.getDirection() == Direction.UP && elevator.getCurrentFloor() > request.getFloorNumber()) {
                elevator.getPendingJobs().add(request);
            }
            return;
        }
        if(request.getFloorNumber() > elevator.getCurrentFloor())
        {
            elevator.getUpMinPQ().offer(request.getFloorNumber());
        }
        else
        {
            elevator.getDownMaxPQ().offer(request.getFloorNumber());
        }
    }
    @Override
    public void Move()
    {
        System.out.println("Entered in moving up state Move with Elevator " + getElevator().getId());
        Elevator elevator = getElevator();
        if(!elevator.getUpMinPQ().isEmpty())
        {
            int targetFloor = elevator.getUpMinPQ().peek();
            elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
            if(elevator.getCurrentFloor() == targetFloor)
            {
                System.out.println("Elevator " + elevator.getId() + " stopped at floor " + targetFloor);
                elevator.getUpMinPQ().poll();
            }
        }
        if(elevator.getUpMinPQ().isEmpty())
        {
            elevator.setCurrentElevatorState(new IdleState(elevator));
            for(Request request:elevator.getPendingJobs())
                elevator.getCurrentElevatorState().addRequest(request);
        }
        System.out.println("Entered out of moving up state Move with elevator " + getElevator().getId());
    }
}
