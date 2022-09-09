package com.klymchuk.elevator.model;

import lombok.Getter;

@Getter
public class Floor {

    private int id;
    private final Button upButton;
    private final Button downButton;

    public Floor(int id, Button upButton, Button downButton) {
        this.id = id;
        this.upButton = upButton;
        this.downButton = downButton;
    }

    public void setId(int id) {
        this.id = id;
    }
}
