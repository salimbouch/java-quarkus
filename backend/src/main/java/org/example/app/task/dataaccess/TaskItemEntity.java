package org.example.app.task.dataaccess;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskItem;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity implements TaskItem {

  @Column(name = "TITLE", nullable = false, length = 64)
  private String title;

  @Column(name = "COMPLETED")
  private boolean completed;

  @Column(name = "STARRED")
  private boolean starred;

  @Column(name = "DEADLINE")
  private LocalDateTime deadline;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LIST_ID")
  private TaskListEntity list;


}
