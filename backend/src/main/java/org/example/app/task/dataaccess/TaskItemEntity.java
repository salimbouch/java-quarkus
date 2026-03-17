package org.example.app.task.dataaccess;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity {

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private String title;
  private boolean completed;
  private boolean starred;
  private LocalDateTime deadline;
  @ManyToOne
  @JoinColumn(name = "LIST_ID")
  private TaskListEntity list;
}
