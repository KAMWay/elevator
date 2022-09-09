package com.klymchuk.elevator.service;

import com.klymchuk.elevator.model.Building;

public interface PrintService {

    void print(String str);
    void print(Building building);
}
