package org.example.app.task.logic.ucs;

import java.util.Optional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.dataaccess.repositories.TaskListRepository;
import org.example.app.task.logic.mapper.TaskItemMapper;
import org.example.app.task.logic.mapper.TaskListMapper;
import org.example.app.task.logic.tos.TaskListCto;
import org.example.app.task.logic.tos.TaskListEto;

@ApplicationScoped
@Named
@Transactional
public class UcFindTaskList {

  @Inject
  private TaskListRepository taskListRepository;

  @Inject
  private TaskListMapper taskListMapper;

  @Inject
  private TaskItemMapper taskItemMapper;

  public TaskListEto findById(Long id) {

    TaskListEntity entity = taskListRepository.findById(id).orElse(null);
    return taskListMapper.toEto(entity);
  }

  public TaskListCto findWithItems(Long id) {
    Optional<TaskListEntity> entity = taskListRepository.findById(id);
    if (entity.isEmpty()) {
      return null;
    }
    TaskListCto cto = new TaskListCto();
    cto.setList(this.taskListMapper.toEto(entity.get()));
    cto.setItems(entity.get().getItems().stream().map(taskItemEntity -> this.taskItemMapper.toEto(taskItemEntity)).toList());
    return cto;
  }


}
