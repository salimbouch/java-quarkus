package org.example.app.task.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
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
  @Operation(summary = "Finds task list by id",
      description = "Find task list by id")
  @APIResponse(description = "The task list",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = TaskListEto.class)))
  @APIResponse(responseCode = "404", description = "Task list not found")
  public TaskListEto findTaskList(
      @Parameter(description = "The id of the task list ", required = true)
      @PathParam("id") Long id) {

    TaskListEto task = this.ucFindTaskList.findById(id);
    if (task == null) {
      throw new NotFoundException("TaskList with id " + id + " does not exist.");
    }
    return task;
  }

  @GET
  @Path("/item/{id}")
  @Operation(summary = "Fetch task item",
      description = "Fetch a task item")
  @APIResponse(description = "Task item",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = TaskItemEto.class)))
  @APIResponse(responseCode = "404", description = "Task item not found")
  public TaskItemEto findItemList(
      @Parameter(description = "The id of the task item to retrieve", required = true)
      @PathParam("id") Long id) {

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
  @Path("/item")
  public void saveTaskItem(TaskItemEto item) {

    if (item.getId() == null) {

    }
  }
}
