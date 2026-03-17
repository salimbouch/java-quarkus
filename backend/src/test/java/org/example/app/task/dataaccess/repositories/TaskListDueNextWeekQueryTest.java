package org.example.app.task.dataaccess.repositories;



import static org.assertj.core.api.Assertions.assertThat;



import java.time.LocalDateTime;

import java.util.List;



import jakarta.inject.Inject;



import org.example.app.task.dataaccess.TaskItemEntity;

import org.example.app.task.dataaccess.TaskListEntity;

import org.junit.jupiter.api.Test;



import io.quarkus.test.TestTransaction;

import io.quarkus.test.junit.QuarkusTest;



@QuarkusTest
class TaskListDueNextWeekQueryTest {

    @Inject TaskListRepository taskListRepository;
    @Inject TaskItemRepository taskItemRepository;

    /**
     * Use-case: "Find all TaskLists, with TaskItems having a due date that expires in the next week".
     * Ergänzt EIN Item in Liste 2 mit Deadline < 7 Tagen und prüft, dass Liste 2 im Ergebnis enthalten ist.
     */
    @Test
    @TestTransaction
    void shouldFindListsWithItemsDueInNextWeek() {
        TaskListEntity list2 = taskListRepository.findById(2L).orElseThrow();

        TaskItemEntity dueSoon = new TaskItemEntity();
        dueSoon.setTitle("DueSoon");
        dueSoon.setCompleted(false);
        dueSoon.setStarred(false);
        dueSoon.setDeadline(LocalDateTime.now().plusDays(3)); // innerhalb der nächsten Woche
        dueSoon.setList(list2);
        taskItemRepository.save(dueSoon);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusDays(7);

        List<TaskListEntity> lists =
                taskListRepository.findListsWithItemsDueBetween(now, nextWeek);

        assertThat(lists)
                .extracting(TaskListEntity::getId)
                .contains(2L);
    }
}