package org.example.app.task.dataaccess;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity {

    @Column(name = "TITLE", nullable = false, length = 64)
    private String title;

    @Column(name = "COMPLETED")
    private boolean completed;

    @Column(name = "STARRED")
    private boolean starred;

    @Column(name = "DEADLINE")
    private LocalDateTime deadline;

    @ManyToOne(optional = false)
    @JoinColumn(name = "LIST_ID", nullable = false)
    private TaskListEntity list;


}
