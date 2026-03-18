package org.example.app.task.logic.mapper;

import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.logic.etos.TaskItemEto;
import org.mapstruct.Mapper;

@Mapper
public interface TaskItemMapper {

  TaskItemEto toEto(TaskItemEntity entity);

  TaskItemEntity toEntity(TaskItemEto eto);

}
