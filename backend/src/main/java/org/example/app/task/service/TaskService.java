package org.example.app.task.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.example.app.task.logic.etos.TaskListEto;
import org.example.app.task.logic.ucs.UcDeleteTaskList;
import org.example.app.task.logic.ucs.UcFindTaskList;

@Path("/task")
public class TaskService {

  @Inject
  private UcFindTaskList ucFindTaskList;

  private UcDeleteTaskList ucDeleteTaskList;

  @GET
  @Path("/list/{id}")
  public TaskListEto findTaskList(@PathParam("id") Long id) {

    TaskListEto task = this.ucFindTaskList.findById(id);
    if (task == null) {
      throw new NotFoundException("TaskList with id " + id + " does not exist.");
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
}
