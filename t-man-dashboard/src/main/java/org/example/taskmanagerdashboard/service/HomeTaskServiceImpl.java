package org.example.taskmanagerdashboard.service;


import org.example.taskmanagerdashboard.model.HomeTask;
import org.example.taskmanagerdashboard.repo.HomeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service("homeTaskService")
@EnableTransactionManagement
@EnableAutoConfiguration
public class HomeTaskServiceImpl implements HomeTaskService {
    private HomeTaskRepository homeTaskRepository;
    @Autowired
    public HomeTaskServiceImpl(HomeTaskRepository homeTaskRepository) {
        this.homeTaskRepository = homeTaskRepository;
    }

    @Override
    @Transactional
    public Iterable<HomeTask> findAllHomeTasks() {
        return homeTaskRepository.findAll();
    }

    @Override
    public Optional<HomeTask> findHomeTaskById(int Id) {
        return homeTaskRepository.findById(Id);
    }

    @Override
    public HomeTask createAndUpdateHomeTask(HomeTask homeTask) {
        return homeTaskRepository.save(homeTask);
    }

    @Override
    public void deleteHomeTaskById(int Id) {
        homeTaskRepository.deleteById(Id);

    }
}
