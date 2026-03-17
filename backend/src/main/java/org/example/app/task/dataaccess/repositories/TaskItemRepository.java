package org.example.app.task.dataaccess.repositories;

import org.example.app.task.dataaccess.TaskItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemRepository extends JpaRepository<TaskItemEntity, Long> {

}
