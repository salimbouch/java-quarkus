package org.example.app.task.logic.ucs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.dataaccess.repositories.TaskListRepository;
import org.example.app.task.logic.mapper.TaskListMapper;

@ApplicationScoped
@Named
@Transactional
public class UcDeleteTaskList {

  @Inject
  private TaskListRepository taskListRepository;

  @Inject
  private TaskListMapper taskListMapper;

  public void deleteTaskList(Long id) {

    taskListRepository.deleteById(id);
  }


}
