package org.example.app.task.logic.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.logic.etos.TaskItemEto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "jakarta")
public interface TaskItemMapper {

  TaskItemEto toEto(TaskItemEntity entity);

  TaskItemEntity toEntity(TaskItemEto eto);

}
