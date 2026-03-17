package org.example.app.task.dataaccess.repositories;

import jakarta.inject.Inject;

import org.assertj.core.api.Assertions;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TaskItemRepositoryTest extends Assertions {

  @Inject
  private TaskItemRepository taskItemRepository;

  @Test
  public void testFindById() {

    // given
    Long itemId = 11L;

    // when
    TaskItemEntity item = this.taskItemRepository.findById(itemId).get();

    // then
    assertThat(item.getTitle()).isEqualTo("Milk");
  }

}
