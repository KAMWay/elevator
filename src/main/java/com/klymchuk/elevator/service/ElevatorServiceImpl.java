package com.klymchuk.elevator.service;

import com.klymchuk.elevator.model.Elevator;
import com.klymchuk.elevator.repository.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class ElevatorServiceImpl implements ElevatorService{

    private final BuildingRepository repository;

    public ElevatorServiceImpl(BuildingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Elevator get() {
        return repository.get().getElevator();
    }
}
