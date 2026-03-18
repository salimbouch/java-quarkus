package org.example.app.task.logic.mapper;

import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.logic.etos.TaskListEto;
import org.mapstruct.Mapper;

@Mapper
public interface TaskListMapper {

  TaskListEto toEto(TaskListEntity entity);

  TaskListEntity toEntity(TaskListEto eto);
}
