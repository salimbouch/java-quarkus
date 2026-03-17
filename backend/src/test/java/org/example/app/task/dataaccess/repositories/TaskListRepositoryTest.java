package org.example.app.task.dataaccess.repositories;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TaskListRepositoryTest {

    @Inject
    TaskListRepository taskListRepository;

}