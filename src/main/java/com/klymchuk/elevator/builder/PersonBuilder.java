package com.klymchuk.elevator.builder;

import com.klymchuk.elevator.model.Person;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Setter
public class PersonBuilder implements Builder<Person> {
    private int id;
    private int curFloor;
    private int needFloor;

    @Override
    public Person create() {
        return new Person(id, curFloor, needFloor);
    }
}
