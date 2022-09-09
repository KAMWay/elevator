package com.klymchuk.elevator.builder;

import com.klymchuk.elevator.model.DownButton;
import com.klymchuk.elevator.model.Floor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class LastFloorBuilder implements Builder<Floor> {

    private int id;

    @Override
    public Floor create() {
        return new Floor(id, null, new DownButton());
    }
}
