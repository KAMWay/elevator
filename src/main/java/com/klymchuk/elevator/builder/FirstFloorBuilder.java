package com.klymchuk.elevator.builder;

import com.klymchuk.elevator.model.Floor;
import com.klymchuk.elevator.model.UpButton;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class FirstFloorBuilder implements Builder<Floor> {

    private int id;
    @Override
    public Floor create() {
        return new Floor(id, new UpButton(), null);
    }
}
