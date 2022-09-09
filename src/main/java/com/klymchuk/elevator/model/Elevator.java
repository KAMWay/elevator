package com.klymchuk.elevator.model;

import lombok.Getter;

import java.util.*;

@Getter
public class Elevator {

    private final int MAX_PERSONS = 5;
    private final int maxFloor;
    private final int minFloor;

    private final List<Person> persons;
    private final Set<Integer> upClickFloors;
    private final Set<Integer> downClickFloors;
    private int maxNeedFloor;
    private int curFloor;
    private int steep;

    public Elevator(int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = 1;
        this.persons = new ArrayList<>(MAX_PERSONS);

        this.upClickFloors = new TreeSet<>();
        this.downClickFloors = new TreeSet<>();

        this.curFloor = 1;
        this.maxNeedFloor = 1;
        this.steep = 1;
    }

    public void move() {
        calculateNextSteep();
        curFloor += steep;
    }

    private void calculateNextSteep() {
        if (upClickFloors.size() == 0 && downClickFloors.size() == 0) {
            steep = 0;
        } else if (curFloor == maxFloor || curFloor == maxNeedFloor) {
            steep = -1;
        } else if (curFloor == 1) {
            steep = 1;
        }
    }

    public void clickUpFromFloor(int idFloor) {
        if (idFloor <= minFloor){
            return;
        }

        upClickFloors.add(idFloor);
    }

    public void clickDownFromFloor(int idFloor) {
        if (idFloor >= maxFloor){
            return;
        }

        downClickFloors.add(idFloor);
    }

    public List<Person> outPersons() {
        List<Person> out = persons.stream()
                .filter(person -> person.getNeedFloor() == curFloor)
                .toList();
        persons.removeIf(person -> person.getNeedFloor() == curFloor);

        if (steep > 0) {
            upClickFloors.remove(curFloor);
        } else {
            downClickFloors.remove(curFloor);
        }

        return out;
    }

    public void inPersons(List<Person> persons) {
        if (persons.isEmpty()){
            return;
        }

        persons.forEach(this::clickInside);
    }

    private void clickInside(Person person) {
        if (person.getNeedFloor() == person.getCurFloor()) {
            return;
        }

        if (person.getCurFloor() > person.getNeedFloor()) {
            downClickFloors.add(person.getNeedFloor());
            maxNeedFloor = Math.max(maxNeedFloor, person.getCurFloor());
        } else {
            upClickFloors.add(person.getNeedFloor());
            maxNeedFloor = Math.max(maxNeedFloor, person.getNeedFloor());
        }

        persons.add(person);
    }
}
