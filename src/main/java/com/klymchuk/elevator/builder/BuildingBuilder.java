package com.klymchuk.elevator.builder;

import com.klymchuk.elevator.model.*;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Setter
public class BuildingBuilder implements Builder<Building> {

    private final int MAX_FLOOR = 20;
    private final int MIN_FLOOR = 5;
    private final FirstFloorBuilder firstFloorBuilder;
    private final FloorBuilder floorBuilder;
    private final LastFloorBuilder lastFloorBuilder;
    private final ElevatorBuilder elevatorBuilder;

    public BuildingBuilder(FirstFloorBuilder firstFloorBuilder, FloorBuilder floorBuilder, LastFloorBuilder lastFloorBuilder, ElevatorBuilder elevatorBuilder) {
        this.firstFloorBuilder = firstFloorBuilder;
        this.floorBuilder = floorBuilder;
        this.lastFloorBuilder = lastFloorBuilder;
        this.elevatorBuilder = elevatorBuilder;
    }

    @Override
    public Building create() {
        Random random = new Random();
        int maxFloor = random.nextInt(MAX_FLOOR - MIN_FLOOR + 1) + MIN_FLOOR;
        elevatorBuilder.setMaxFloor(maxFloor);

        return new Building(elevatorBuilder.create(), createFloors(maxFloor), new ArrayList<>());
    }

    private List<Floor> createFloors(int maxFloor) {
        List<Floor> floors = new ArrayList<>(maxFloor);

        firstFloorBuilder.setId(1);
        floors.add(0, firstFloorBuilder.create());

        for (int i = 1; i < maxFloor - 1; i++) {
            Floor floor = floorBuilder.create();
            floor.setId(i + 1);
            floors.add(i, floor);
        }

        lastFloorBuilder.setId(maxFloor);
        floors.add(maxFloor - 1, lastFloorBuilder.create());

        return floors;
    }
}
