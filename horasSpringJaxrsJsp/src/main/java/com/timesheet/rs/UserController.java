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

import com.timesheet.model.User;
import com.timesheet.respository.UserRepository;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Component

public class UserController {

	@Autowired
	private UserRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String hello() {
		return "hola users";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public User usuario() {
		User usuario = new User();
		usuario.setName("jordi15");
		usuario.setCode("jordi15");

		repository.save(usuario);
		return usuario;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Iterable<User> geUsers() {

		Iterable<User> listOfUsers = repository.findAll();
		return listOfUsers;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") String id) {
		return repository.findOne(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public User addCountry(User user) {
		return repository.save(user);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		return repository.save(user);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  deleteUser(@PathParam("id") String id) {
		repository.delete(id);
		return Response.ok().build();
		
	}

}
