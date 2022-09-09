package com.klymchuk.elevator.builder;

import com.klymchuk.elevator.model.Elevator;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class ElevatorBuilder implements Builder<Elevator> {
    private int maxFloor;

    @Override
    public Elevator create() {
        return new Elevator(maxFloor);
    }
}
