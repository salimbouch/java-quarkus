package org.example.app.task.logic.ucs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.dataaccess.repositories.TaskListRepository;
import org.example.app.task.logic.etos.TaskListEto;
import org.example.app.task.logic.mapper.TaskListMapper;

@ApplicationScoped
@Named
@Transactional
public class UcFindTaskList {

  @Inject
  private TaskListRepository taskListRepository;

  @Inject
  private TaskListMapper taskListMapper;

  public TaskListEto findById(Long id) {

    TaskListEntity entity = taskListRepository.findById(id).orElse(null);
    return taskListMapper.toEto(entity);
  }


}
