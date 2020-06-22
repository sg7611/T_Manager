package org.example.taskmanagerdashboard.repo;

import org.example.taskmanagerdashboard.model.HomeTask;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableAutoConfiguration
@EnableTransactionManagement
public interface HomeTaskRepository extends CrudRepository<HomeTask,Integer> {
}
