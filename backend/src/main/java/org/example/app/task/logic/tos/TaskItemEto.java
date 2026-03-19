package org.example.app.task.logic.tos;

import java.time.LocalDateTime;

import org.example.app.general.common.AbstractEto;
import org.example.app.task.common.TaskItem;
import org.example.app.task.dataaccess.TaskListEntity;

import lombok.Data;

@Data
public class TaskItemEto extends AbstractEto implements TaskItem {

  private String title;

  private boolean completed;


  private boolean starred;


  private LocalDateTime deadline;


  private TaskListEntity list;

}
