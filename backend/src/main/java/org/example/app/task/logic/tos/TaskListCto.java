package org.example.app.task.logic.tos;

import java.util.List;

import lombok.Data;

@Data
public class TaskListCto {

  private TaskListEto list;

  private List<TaskItemEto> items;
}
