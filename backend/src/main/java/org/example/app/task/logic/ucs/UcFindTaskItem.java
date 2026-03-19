package org.example.app.task.logic.ucs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.repositories.TaskItemRepository;
import org.example.app.task.logic.etos.TaskItemEto;
import org.example.app.task.logic.mapper.TaskItemMapper;

@ApplicationScoped
@Named
@Transactional
public class UcFindTaskItem {

  @Inject
  private TaskItemRepository taskItemRepository;

  @Inject
  private TaskItemMapper taskItemMapper;

  public TaskItemEto findById(Long id) {

    TaskItemEntity entity = taskItemRepository.findById(id).orElse(null);
    return taskItemMapper.toEto(entity);
  }
}
