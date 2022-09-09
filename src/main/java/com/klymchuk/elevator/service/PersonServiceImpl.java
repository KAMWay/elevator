package com.klymchuk.elevator.service;

import com.klymchuk.elevator.model.Person;
import com.klymchuk.elevator.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> get() {
        return repository.get();
    }
}
