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

import com.timesheet.model.Hora;
import com.timesheet.respository.HoraRepository;

import io.swagger.annotations.Api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/horas")
@Component
@Api

public class HoraController {

	@Autowired
	private HoraRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String hello() {
		return "hola Horas";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Iterable<Hora> geHoras() {

		Iterable<Hora> listOfHoras = repository.findAll();
		return listOfHoras;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hora getHoraById(@PathParam("id") Long id) {
		return repository.findOne(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Hora addCountry(Hora hora) {
		return repository.save(hora);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Hora updateHora(Hora hora) {
		return repository.save(hora);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  deleteHora(@PathParam("id") Long id) {
		repository.delete(id);
		return Response.ok().build();
		
	}
	
}