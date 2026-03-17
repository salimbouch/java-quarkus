package org.example.app.task.dataaccess;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity {

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private String title;
}
