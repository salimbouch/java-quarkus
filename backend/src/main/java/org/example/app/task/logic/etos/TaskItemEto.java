package org.example.app.task.logic.etos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.app.general.common.AbstractEto;
import org.example.app.task.common.TaskItem;
import org.example.app.task.dataaccess.TaskListEntity;

import java.time.LocalDateTime;

@Data
public class TaskItemEto extends AbstractEto implements TaskItem {

    private String title;

    private boolean completed;


    private boolean starred;


    private LocalDateTime deadline;


    private TaskListEntity list;

}
