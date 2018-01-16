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

import com.timesheet.model.Project;
import com.timesheet.respository.ProjectRepository;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/projects")
@Component

public class ProjectController {

	@Autowired
	private ProjectRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String hello() {
		return "hola Projects";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Iterable<Project> geProjects() {

		Iterable<Project> listOfProjects = repository.findAll();
		return listOfProjects;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Project getProjectById(@PathParam("id") String id) {
		return repository.findOne(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Project addCountry(Project Project) {
		return repository.save(Project);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Project updateProject(Project Project) {
		return repository.save(Project);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  deleteProject(@PathParam("id") String id) {
		repository.delete(id);
		return Response.ok().build();
		
	}
	
}