package org.example.app.task.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.example.app.task.logic.etos.TaskItemEto;
import org.example.app.task.logic.etos.TaskListEto;
import org.example.app.task.logic.ucs.UcDeleteTaskList;
import org.example.app.task.logic.ucs.UcFindTaskItem;
import org.example.app.task.logic.ucs.UcFindTaskList;

@Path("/task")
public class TaskService {

  @Inject
  private UcFindTaskList ucFindTaskList;

  @Inject
  private UcDeleteTaskList ucDeleteTaskList;

  @Inject
  private UcFindTaskItem ucFindTaskItem;

  @GET
  @Path("/list/{id}")
  public TaskListEto findTaskList(@PathParam("id") Long id) {

    TaskListEto task = this.ucFindTaskList.findById(id);
    if (task == null) {
      throw new NotFoundException("TaskList with id " + id + " does not exist.");
    }
    return task;
  }

  @GET
  @Path("/item/{id}")
  public TaskItemEto findItemList(@PathParam("id") Long id) {

    TaskItemEto task = this.ucFindTaskItem.findById(id);
    if (task == null) {
      throw new NotFoundException("TaskItem with id " + id + " does not exist.");
    }
    return task;
  }

  @DELETE
  @Path("/list/{id}")
  public String deleteTaskList(@PathParam("id") Long id) {

    if (ucFindTaskList.findById(id) != null) {
      ucDeleteTaskList.deleteTaskList(id);
      return "Task list deleted";
    }
    throw new NotFoundException("TaskList with id " + id + " does not exist.");
  }

  @POST
  @Path("/item/{id}")
  public void saveTaskItem(TaskItemEto item) {

    if (item.getId() == null) {
      
    }
  }
}
