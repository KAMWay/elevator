package com.klymchuk.elevator.model;

public class UpButton implements Button {

    private Boolean isClick;

    public UpButton() {
        this.isClick = false;
    }

    @Override
    public void click() {
        isClick = true;
    }

    @Override
    public boolean isClick() {
        return isClick;
    }
}
