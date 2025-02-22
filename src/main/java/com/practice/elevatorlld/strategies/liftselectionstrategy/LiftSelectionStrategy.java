package com.practice.elevatorlld.strategies.liftselectionstrategy;

import com.practice.elevatorlld.models.Elevator;

import java.util.List;

public interface LiftSelectionStrategy {
    Elevator SelectLift(List<Elevator> elevators, int floor);
}
