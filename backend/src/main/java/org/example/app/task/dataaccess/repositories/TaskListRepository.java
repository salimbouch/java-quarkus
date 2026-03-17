package org.example.app.task.dataaccess.repositories;

import org.example.app.task.dataaccess.TaskListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskListEntity, Long> {

    //Alle Tasklists ohne taskitem
    List<TaskListEntity> findByItemsEmpty();

    @Query("""
                 select distinct tl
                 from TaskListEntity tl 
                 join tl.items ti 
                 where ti.deadline between :from and :to
            """)
    List<TaskListEntity> findListsWithItemsDueBetween(LocalDateTime from, LocalDateTime to);


}
