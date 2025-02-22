package com.practice.elevatorlld.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Setter
@Getter
public class Elevator extends BaseModel {
    private Direction direction;
    private int currentFloor;
    private PriorityQueue<Integer> upMinPQ = new PriorityQueue<>(); // min heap
    private PriorityQueue<Integer> downMaxPQ = new PriorityQueue<>(Collections.reverseOrder()); // maxheap
    private List<Integer> pendingJobsUp = new ArrayList<>();
    private List<Integer> PendingJobsDown = new ArrayList<>();
}
