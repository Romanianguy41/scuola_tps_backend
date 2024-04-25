package dascalu.scuola.controllers;

import java.sql.SQLException;
import java.util.List;

import dascalu.scuola.models.Studente;
import dascalu.scuola.service.StudenteService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("studente")
public class StudenteController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Studente> getStudents() throws ClassNotFoundException, SQLException {
		return StudenteService.getStudents();
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Studente> getStudents(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return StudenteService.getStudents(search);	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createStudent(String userRequest) throws ClassNotFoundException, SQLException {
		return StudenteService.createStudent(userRequest);
	}
	
	@DELETE
	@Path("{idStudente}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteStudent(@PathParam("idStudente") String idStudente) throws ClassNotFoundException, SQLException {
		return StudenteService.deleteStudent(idStudente);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateStudents(String userRequest) throws ClassNotFoundException, SQLException{
		return StudenteService.updateStudent(userRequest);
	}
}
