package com.practice.elevatorlld;

import com.practice.elevatorlld.controllers.ElevatorController;
import com.practice.elevatorlld.models.Direction;
import com.practice.elevatorlld.models.Elevator;
import com.practice.elevatorlld.models.Request;
import com.practice.elevatorlld.models.RequestType;
import com.practice.elevatorlld.services.ElevatorService;
import com.practice.elevatorlld.strategies.liftselectionstrategy.LiftSelectionStrategy;
import com.practice.elevatorlld.strategies.liftselectionstrategy.OddEvenLiftStrategy;

import java.util.Arrays;
import java.util.List;

public class ManualMain {
    public static void main(String[] args) {
        // Manually create controller & service
        List<Elevator> elevatorList = Arrays.asList(
                    new Elevator(0),
                    new Elevator(0),
                    new Elevator(0)
            );
        LiftSelectionStrategy liftSelectionStrategy = new OddEvenLiftStrategy();
        ElevatorService elevatorService = new ElevatorService(elevatorList,liftSelectionStrategy);
        ElevatorController controller = new ElevatorController(elevatorService);
        controller.start();

        //System.out.println(elevatorService.getElevators().get(2).getId());
        Request request = new Request(Direction.UP, 3, RequestType.EXTERNAL);
        controller.requestForLift(request);
    }
}
