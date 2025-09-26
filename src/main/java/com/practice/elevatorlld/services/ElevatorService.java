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
