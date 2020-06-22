package org.example.taskmanagerdashboard;

import org.example.taskmanagerdashboard.model.HomeTask;
import org.example.taskmanagerdashboard.repo.HomeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class TaskManagerDashboardApplication implements CommandLineRunner {
    private HomeTaskRepository homeTaskRepository;


    @Autowired
    public TaskManagerDashboardApplication( HomeTaskRepository homeTaskRepository) {
        this.homeTaskRepository = homeTaskRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerDashboardApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        homeTaskRepository.save(new HomeTask(3,"workFromHome",8,"complete","20-06-2020","21-06-20","Blue"));
        homeTaskRepository.save(new HomeTask(4,"Dusting",6,"pending","10-06-2020","30-06-20","Orange"));
    }
}
