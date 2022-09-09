package com.klymchuk.elevator.service;

import com.klymchuk.elevator.model.Building;
import com.klymchuk.elevator.model.Elevator;
import com.klymchuk.elevator.model.Floor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PrintServiceImpl implements PrintService {

    private final int SEP = 60;

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public void print(Building building) {
        Elevator elevator = building.getElevator();

        StringBuilder sb = new StringBuilder();
        for (Floor floor : building.getFloors()) {
            StringBuilder sbFloor = new StringBuilder();
            sbFloor.append(
                    floor.getId() == building.getElevator().getCurFloor()
                            ? getElevatorStateString(elevator)
                            : String.join("", Collections.nCopies(SEP, " "))
            );
            sbFloor.append("| F-").append(floor.getId()).append(" ");
            sbFloor.append(building.getPersons().stream()
                    .filter(person -> !building.getElevator().getPersons().contains(person))
                    .filter(e -> e.getCurFloor() == floor.getId())
                    .toList());
            sbFloor.append("\n");
            sb.insert(0, sbFloor);
        }

        sb.append("----------------");

        System.out.println(sb);
    }

    private String getElevatorStateString(Elevator elevator) {
        StringBuilder sb = new StringBuilder();

        sb.append(getSteepStateString(elevator.getSteep()));
        sb.append(elevator.getPersons());
        sb.append(sb.length() < SEP
                ? String.join("", Collections.nCopies(SEP - sb.length(), " "))
                : "");


        return sb.toString();
    }

    private String getSteepStateString(int steep) {
        return switch (steep) {
            case 1 -> "^";
            case -1 -> "v";
            default -> "*";
        };
    }
}
