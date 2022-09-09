package com.klymchuk.elevator.repository;

import com.klymchuk.elevator.builder.PersonBuilder;
import com.klymchuk.elevator.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    private final List<Person> persons;

    public PersonRepositoryImpl(PersonBuilder personBuilder, BuildingRepository buildingRepository) {
        Random random = new Random();
        int size = buildingRepository.get().getFloors().size();
        int count = random.nextInt(11) * size;

        persons = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            personBuilder.setId(i);
            int curFloor = random.nextInt(size) + 1;

            int needFloor;
            do {
                needFloor = random.nextInt(size) + 1;
            } while (needFloor == curFloor);

            personBuilder.setCurFloor(curFloor);
            personBuilder.setNeedFloor(needFloor);
            persons.add(personBuilder.create());
        }
    }

    @Override
    public List<Person> get() {
        return persons;
    }
}
