package com.klymchuk.elevator.service;

import com.klymchuk.elevator.model.Building;
import com.klymchuk.elevator.model.Person;

import java.util.List;

public interface BuildingService {

    Building get();

    void addPersons(List<Person> persons);

    void moveElevator();

}
