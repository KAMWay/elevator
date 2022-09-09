package com.klymchuk.elevator.repository;

import com.klymchuk.elevator.builder.BuildingBuilder;
import com.klymchuk.elevator.model.Building;
import com.klymchuk.elevator.model.Elevator;
import com.klymchuk.elevator.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

    private final Building building;

    public BuildingRepositoryImpl(BuildingBuilder buildingBuilder) {
        this.building = buildingBuilder.create();
    }

    @Override
    public Building get() {
        return building;
    }

    @Override
    public void addPerson(List<Person> persons) {
        building.getPersons().addAll(persons);

        persons.stream()
                .filter(person -> person.getCurFloor() > person.getNeedFloor())
                .map(Person::getCurFloor)
                .distinct()
                .forEach(building.getElevator()::clickDownFromFloor);

        persons.stream()
                .filter(person -> person.getCurFloor() < person.getNeedFloor())
                .map(Person::getCurFloor)
                .distinct()
                .forEach(building.getElevator()::clickUpFromFloor);
    }

    @Override
    public void moveElevator() {
        Elevator elevator = building.getElevator();
        List<Person> in = building.getPersons().stream()
                .filter(person -> person.getCurFloor() == elevator.getCurFloor())
                .filter(person -> elevator.getSteep() > 0 && elevator.getCurFloor() != elevator.getMaxFloor()
                        ? person.getCurFloor() < person.getNeedFloor()
                        : person.getCurFloor() > person.getNeedFloor())
                .limit(elevator.getMAX_PERSONS() - elevator.getPersons().size())
                .toList();

        elevator.inPersons(in);
        elevator.move();
        updPersons(elevator.outPersons());
    }
    public void updPersons(List<Person> persons) {
        building.getPersons().stream()
                .filter(persons::contains)
                .forEach(person -> person.setCurFloor(person.getNeedFloor()));
    }
}
