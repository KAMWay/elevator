package com.klymchuk.elevator.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    private final int id;
    private int curFloor;
    private int needFloor;

    public void setCurFloor(int curFloor) {
        this.curFloor = curFloor;
    }

    public void setNeedFloor(int needFloor) {
        this.needFloor = needFloor;
    }

    @Override
    public String toString() {
        return "{" + id + "->f" + needFloor + "}";
    }
}
