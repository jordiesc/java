package com.timesheet.rs;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.timesheet.model.Task;
import com.timesheet.respository.TaskRepository;

import io.swagger.annotations.Api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tasks")
@Api(value = "/rest" )
@Component

public class TaskController {

	@Autowired
	private TaskRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String hello() {
		return "hola tasks";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Iterable<Task> geTasks() {

		Iterable<Task> listOfTasks = repository.findAll();
		return listOfTasks;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Task getTaskById(@PathParam("id") String id) {
		return repository.findOne(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Task addCountry(Task Task) {
		return repository.save(Task);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Task updateTask(Task Task) {
		return repository.save(Task);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  deleteTask(@PathParam("id") String id) {
		repository.delete(id);
		return Response.ok().build();
		
	}
	
}