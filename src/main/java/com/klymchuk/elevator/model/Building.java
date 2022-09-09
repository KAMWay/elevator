package com.klymchuk.elevator.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Building {

    private final Elevator elevator;
    private final List<Floor> floors;

    private final List<Person> persons;

    public Building(Elevator elevator, List<Floor> floors, List<Person> persons) {
        this.elevator = elevator;
        this.floors = floors;
        this.persons = persons;
    }
}
