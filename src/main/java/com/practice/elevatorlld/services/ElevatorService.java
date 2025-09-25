package com.practice.elevatorlld.services;

import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;
import com.practice.elevatorlld.strategies.liftselectionstrategy.LiftSelectionStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@AllArgsConstructor
@Getter
public class ElevatorService {
    private List<Elevator> elevators = new ArrayList<>();
    private LiftSelectionStrategy liftSelectionStrategy;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    //can be both internal or external request
    public void requestForLift(Request request)
    {
        Elevator elevator = liftSelectionStrategy.SelectLift(elevators, request.getFloorNumber());
        elevator.getCurrentElevatorState().addRequest(request);
    }

    public void start()
    {
        for (Elevator elevator : elevators) {
            executor.submit(() -> runElevator(elevator));
        }
    }

    private void runElevator(Elevator elevator) {
        System.out.println(Thread.currentThread().getName());
        while (elevator.isRunning()) {
            elevator.getCurrentElevatorState().Move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


}














//        if(elevator.getDirection().equals(Direction.UP))
//        {
//            if(userFloor < elevator.getCurrentFloor())
//            {
//                if(userDirection.equals(Direction.UP))
//                {
//                    elevator.getPendingJobsUp().add(userFloor);
//                }
//                else
//                {
//                    elevator.getPendingJobsDown().add(userFloor);
//                }
//                return;
//            }
//            //now we have greater floors request only
//            if(userDirection.equals(Direction.UP))
//            {
//                elevator.getUpMinPQ().offer(userFloor);
//            }
//            else
//            {
//                elevator.getDownMaxPQ().offer(userFloor);
//            }
//        }
//        else if(elevator.getDirection().equals(Direction.DOWN))
//        {
//            if(userFloor > elevator.getCurrentFloor())
//            {
//                if(userDirection.equals(Direction.UP))
//                {
//                    elevator.getPendingJobsUp().add(userFloor);
//                }
//                else
//                {
//                    elevator.getDownMaxPQ().offer(userFloor);
//                }
//                return;
//            }
//
//        }

//    public void moveElevator(Elevator elevator)
//    {
//        //if(elevator.ge)
//        if(elevator.getDirection().equals(Direction.UP))
//        {
//            if(!elevator.getUpMinPQ().isEmpty())
//            {
//                int destinationFloor = elevator.getUpMinPQ().poll();
//                moveElevatorSD(elevator,elevator.getCurrentFloor(), destinationFloor);
//                elevator.setCurrentFloor(destinationFloor);
//            }
//            else
//            {
//                elevator.setDirection(Direction.DOWN);
//                elevator.getDownMaxPQ().addAll(elevator.getPendingJobsDown());
//                elevator.getPendingJobsDown().clear();
//                elevator.getUpMinPQ().addAll(elevator.getPendingJobsUp());
//                elevator.getPendingJobsUp().clear();
//
////                if(!elevator.getDownMaxPQ().isEmpty())
////                {
////                    int destinationFloor = elevator.getDownMaxPQ().poll();
////                    moveElevatorSD(elevator,elevator.getCurrentFloor(), destinationFloor);
////                    elevator.setCurrentFloor(destinationFloor);
////
////                }
//            }
//        }
//        if(elevator.getDirection().equals(Direction.DOWN))
//        {
//            if(!elevator.getDownMaxPQ().isEmpty())
//            {
//                int destinationFloor = elevator.getDownMaxPQ().poll();
//                moveElevatorSD(elevator,elevator.getCurrentFloor(), destinationFloor);
//                elevator.setCurrentFloor(destinationFloor);
//            }
//            else
//            {
//                elevator.setDirection(Direction.UP);
//            }
//        }
//    }
//    public void moveElevatorSD(Elevator elevator,int sourceFloor, int destinationFloor)
//    {
//        if(elevator.getDirection().equals(Direction.UP))
//        {
//            //minheap will done fisrt then maxheap
//
//        }
//    }
//}
