package org.example.app.task.dataaccess.repositories;

import org.example.app.task.dataaccess.TaskListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskListEntity, Long> {

}
