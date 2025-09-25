package com.practice.elevatorlld.elevatorstates;

import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;
import lombok.Getter;

@Getter
public abstract class ElevatorState {
    private Elevator elevator;
    public ElevatorState(Elevator elevator)
    {
        this.elevator = elevator;
    }
    abstract public void Move();
    abstract public void addRequest(Request request);
}
