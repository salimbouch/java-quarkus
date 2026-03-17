package org.example.app.task.dataaccess.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.inject.Inject;

import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.TaskListEntity;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import java.util.List;

@QuarkusTest
class TaskItemRepositoryTest {

    @Inject
    TaskItemRepository taskItemRepository;
    @Inject
    TaskListRepository taskListRepository;

    @Test
    void testFindById() {

        TaskListEntity list = new TaskListEntity();
        list.setTitle("Groceries");
        list = taskListRepository.save(list);

        TaskItemEntity item = new TaskItemEntity();
        item.setTitle("Milk");
        item.setCompleted(false);
        item.setStarred(false);
        item.setList(list);

        item = taskItemRepository.save(item);
        Long id = item.getId();

        TaskItemEntity loaded = taskItemRepository.findById(id).orElse(null);

        assertThat(loaded).isNotNull();
        assertThat(loaded.getTitle()).isEqualTo("Milk");
    }

}
