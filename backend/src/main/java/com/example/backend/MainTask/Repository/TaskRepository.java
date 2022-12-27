package com.example.backend.MainTask.Repository;

import com.example.backend.MainTask.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {}
