package com.practice.elevatorlld.strategies.liftselectionstrategy;

import com.practice.elevatorlld.models.Elevator;

import java.util.List;

public class OddEvenLiftStrategy implements LiftSelectionStrategy{

    @Override
    public Elevator SelectLift(List<Elevator> elevators, int floor) {
        for(Elevator elevator:elevators)
        {
            if(elevator.getId()%2 == 1 && floor%2 == 1
            || elevator.getId()%2 == 0 && floor%2 == 0)
            {
                return elevator;
            }
        }
        return null;
    }
}
