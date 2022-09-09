package com.klymchuk.elevator.service;

import com.klymchuk.elevator.model.Building;
import com.klymchuk.elevator.model.Person;
import com.klymchuk.elevator.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService{
    private final BuildingRepository repository;

    public BuildingServiceImpl(BuildingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Building get() {
        return repository.get();
    }

    @Override
    public void addPersons(List<Person> persons) {
        repository.addPerson(persons);
    }

    @Override
    public void moveElevator() {
        repository.moveElevator();
    }
}
