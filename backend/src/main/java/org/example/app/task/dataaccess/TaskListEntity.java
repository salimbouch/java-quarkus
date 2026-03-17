package org.example.app.task.dataaccess;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity {

  private String title;
}
