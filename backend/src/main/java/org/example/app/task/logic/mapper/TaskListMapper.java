package org.example.app.task.logic.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.logic.etos.TaskListEto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "jakarta")
public interface TaskListMapper {

  TaskListEto toEto(TaskListEntity entity);

  TaskListEntity toEntity(TaskListEto eto);
}
