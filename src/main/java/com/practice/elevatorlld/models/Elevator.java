package com.practice.elevatorlld.models;

import com.practice.elevatorlld.elevatorstates.ElevatorState;
import com.practice.elevatorlld.elevatorstates.IdleState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class Elevator{
    private static final AtomicInteger counter = new AtomicInteger(0);
    private int id;
    private int currentFloor;
    private boolean isRunning = true;
    private PriorityQueue<Integer> upMinPQ = new PriorityQueue<>(); // min heap
    private PriorityQueue<Integer> downMaxPQ = new PriorityQueue<>(Collections.reverseOrder()); // maxheap
    private List<Integer> pendingJobs = new ArrayList<>();
    private ElevatorState currentElevatorState;

    public Elevator(int startingFloor) {
        this.id = counter.incrementAndGet();
        this.currentFloor = startingFloor;
        this.upMinPQ = new PriorityQueue<>();
        this.downMaxPQ = new PriorityQueue<>(Collections.reverseOrder());
        this.pendingJobs = new ArrayList<>();

        // initial state = Idle
        this.currentElevatorState = new IdleState(this);
    }
}
