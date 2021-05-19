package ru.job4j.srp;

import java.util.List;

public interface TaskManager<T> {
    void addTask();

    List<T> getTask();
}
