package com.klymchuk.elevator.repository;

import com.klymchuk.elevator.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> get();
}
