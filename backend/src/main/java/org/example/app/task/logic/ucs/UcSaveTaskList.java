package org.example.app.task.logic.ucs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.dataaccess.repositories.TaskListRepository;
import org.example.app.task.logic.mapper.TaskListMapper;
import org.example.app.task.logic.tos.TaskListEto;

@ApplicationScoped
@Named
@Transactional
public class UcSaveTaskList {

  @Inject
  private TaskListRepository taskListRepository;

  @Inject
  private TaskListMapper taskListMapper;

  public TaskListEto save(TaskListEto eto) {

    return this.taskListMapper.toEto(this.taskListRepository.save(this.taskListMapper.toEntity(eto)));
  }


}
