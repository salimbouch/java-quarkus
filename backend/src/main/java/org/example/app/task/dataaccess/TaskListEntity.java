package org.example.app.task.dataaccess;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity implements TaskList {

  @Column(name = "TITLE", nullable = false, length = 64)
  private String title;

  @OneToMany(mappedBy = "list", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TaskItemEntity> items;
}
