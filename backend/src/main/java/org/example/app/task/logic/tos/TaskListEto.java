package org.example.app.task.logic.tos;

import org.example.app.general.common.AbstractEto;
import org.example.app.task.common.TaskList;

import lombok.Data;

@Data
public class TaskListEto extends AbstractEto implements TaskList {

  private String title;
}
