package org.example.taskmanagerdashboard.controller;

import org.example.taskmanagerdashboard.model.HomeTask;
import org.example.taskmanagerdashboard.service.HomeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeTaskController {
    private HomeTaskService homeTaskService;
    @Autowired
    public HomeTaskController(HomeTaskService homeTaskService) {
        this.homeTaskService = homeTaskService;
    }
    @GetMapping(value = {"/homeTasks"},produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<HomeTask>> getAllHomeTasks()
    {
        return ResponseEntity.status(HttpStatus.OK).body(homeTaskService.findAllHomeTasks());
    }
    @GetMapping(value = "/homeTasks/{homeTaskId}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<HomeTask>> getOfficeTasksById(@PathVariable("homeTaskId") int Id){
        return ResponseEntity.status(HttpStatus.OK).body(homeTaskService.findHomeTaskById(Id));
    }
    @PostMapping("/homeTasks")
    public ResponseEntity<HomeTask> createHomeTask(@Valid @RequestBody HomeTask homeTask)
    {

        return ResponseEntity.status(HttpStatus.OK).body(homeTaskService.createAndUpdateHomeTask(homeTask));
    }
    @PutMapping("/homeTasks")
    public ResponseEntity<HomeTask> updateHomeTask(@Valid @RequestBody HomeTask homeTask)
    {
        return ResponseEntity.status(HttpStatus.OK).body(homeTaskService.createAndUpdateHomeTask(homeTask));
    }
    @DeleteMapping("/homeTasks/{taskId}")
    public ResponseEntity<String> deleteHomeTaskById(@PathVariable("taskId") int Id)
    {
        homeTaskService.deleteHomeTaskById(Id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
}
