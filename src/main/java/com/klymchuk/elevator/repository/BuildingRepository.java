package com.klymchuk.elevator.repository;

import com.klymchuk.elevator.model.Building;
import com.klymchuk.elevator.model.Person;

import java.util.List;

public interface BuildingRepository {

    Building get();

    void addPerson(List<Person> persons);

    void moveElevator();
}
