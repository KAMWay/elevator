package com.klymchuk.elevator.builder;

import com.klymchuk.elevator.model.DownButton;
import com.klymchuk.elevator.model.Floor;
import com.klymchuk.elevator.model.UpButton;
import org.springframework.stereotype.Component;

@Component
public class FloorBuilder implements Builder<Floor> {

    @Override
    public Floor create() {
        return new Floor(0, new UpButton(), new DownButton());
    }
}
