package org.example.app.task.logic.mapper;

import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.logic.tos.TaskItemEto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface TaskItemMapper {

  TaskItemEto toEto(TaskItemEntity entity);

  TaskItemEntity toEntity(TaskItemEto eto);

}
