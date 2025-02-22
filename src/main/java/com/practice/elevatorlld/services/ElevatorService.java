package com.practice.elevatorlld.services;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import org.springframework.data.relational.core.sql.In;

import java.util.*;

public class ElevatorService {
//    PriorityQueue<Integer> upMinPQ = new PriorityQueue<>(); // min heap
//    PriorityQueue<Integer> downMaxPQ = new PriorityQueue<>(Collections.reverseOrder()); // maxheap
//    List<Integer> pendingJobsUp = new ArrayList<>();
//    List<Integer> getPendingJobsDown = new ArrayList<>();


    public void requestForLift(Elevator elevator, Direction userDirection,
                               int userFloor)
    {
        if(elevator.getDirection().equals(Direction.UP))
        {
            if(userFloor < elevator.getCurrentFloor())
            {
                if(userDirection.equals(Direction.UP))
                {
                    elevator.getPendingJobsUp().add(userFloor);
                }
                else
                {
                    elevator.getPendingJobsDown().add(userFloor);
                }
                return;
            }
            //now we have greater floors request only
            if(userDirection.equals(Direction.UP))
            {
                elevator.getUpMinPQ().offer(userFloor);
            }
            else
            {
                elevator.getDownMaxPQ().offer(userFloor);
            }
        }
        else if(elevator.getDirection().equals(Direction.DOWN))
        {
            if(userFloor > elevator.getCurrentFloor())
            {
                if(userDirection.equals(Direction.UP))
                {
                    elevator.getPendingJobsUp().add(userFloor);
                }
                else
                {
                    elevator.getDownMaxPQ().offer(userFloor);
                }
                return;
            }

        }
    }

    public void moveElevator(Elevator elevator)
    {
        //if(elevator.ge)
        if(elevator.getDirection().equals(Direction.UP))
        {
            if(!elevator.getUpMinPQ().isEmpty())
            {
                int destinationFloor = elevator.getUpMinPQ().poll();
                moveElevatorSD(elevator,elevator.getCurrentFloor(), destinationFloor);
                elevator.setCurrentFloor(destinationFloor);
            }
            else
            {
                elevator.setDirection(Direction.DOWN);
                elevator.getDownMaxPQ().addAll(elevator.getPendingJobsDown());
                elevator.getPendingJobsDown().clear();
                elevator.getUpMinPQ().addAll(elevator.getPendingJobsUp());
                elevator.getPendingJobsUp().clear();

//                if(!elevator.getDownMaxPQ().isEmpty())
//                {
//                    int destinationFloor = elevator.getDownMaxPQ().poll();
//                    moveElevatorSD(elevator,elevator.getCurrentFloor(), destinationFloor);
//                    elevator.setCurrentFloor(destinationFloor);
//
//                }
            }
        }
        if(elevator.getDirection().equals(Direction.DOWN))
        {
            if(!elevator.getDownMaxPQ().isEmpty())
            {
                int destinationFloor = elevator.getDownMaxPQ().poll();
                moveElevatorSD(elevator,elevator.getCurrentFloor(), destinationFloor);
                elevator.setCurrentFloor(destinationFloor);
            }
            else
            {
                elevator.setDirection(Direction.UP);
            }
        }
    }
    public void moveElevatorSD(Elevator elevator,int sourceFloor, int destinationFloor)
    {
        if(elevator.getDirection().equals(Direction.UP))
        {
            //minheap will done fisrt then maxheap

        }
    }
}
