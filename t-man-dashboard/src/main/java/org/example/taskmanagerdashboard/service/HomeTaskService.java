package org.example.taskmanagerdashboard.service;


import org.example.taskmanagerdashboard.model.HomeTask;

import java.util.Optional;

public interface HomeTaskService {
    public Iterable<HomeTask> findAllHomeTasks();
    public Optional<HomeTask> findHomeTaskById(int Id);
    public HomeTask createAndUpdateHomeTask(HomeTask homeTask);

    public void deleteHomeTaskById(int Id);
}
