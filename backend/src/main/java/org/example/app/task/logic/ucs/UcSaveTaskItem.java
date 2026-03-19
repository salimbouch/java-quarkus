package org.example.app.task.logic.ucs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.dataaccess.repositories.TaskItemRepository;
import org.example.app.task.logic.mapper.TaskItemMapper;
import org.example.app.task.logic.tos.TaskItemEto;

@ApplicationScoped
@Named
@Transactional
public class UcSaveTaskItem {

  @Inject
  private TaskItemRepository taskItemRepository;

  @Inject
  private TaskItemMapper taskItemMapper;

  public TaskItemEto save(TaskItemEto eto) {

    return this.taskItemMapper.toEto(this.taskItemRepository.save(this.taskItemMapper.toEntity(eto)));
  }

}
