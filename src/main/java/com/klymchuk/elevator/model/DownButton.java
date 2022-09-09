package com.klymchuk.elevator.model;

public class DownButton implements Button {

    private boolean isClick;

    public DownButton() {
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
