package dascalu.scuola.controllers;

import java.sql.SQLException;

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
	public String getStudents() throws ClassNotFoundException, SQLException {
		return StudenteService.getStudents();
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudents(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return StudenteService.getStudents(search);	
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void createStudent(String userRequest) throws ClassNotFoundException, SQLException {
		StudenteService.createStudent(userRequest);
	}
	
	@DELETE
	@Path("{idStudente}")
	public void deleteStudent(@PathParam("idStudente") String idStudente) throws ClassNotFoundException, SQLException {
		StudenteService.deleteStudent(idStudente);
	}
	
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public void updateStudents(String userRequest) throws ClassNotFoundException, SQLException{
		StudenteService.updateStudent(userRequest);
	}
	
	@PUT
	@Path("classe/{idStudente}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void removeStudentClass(@PathParam("idStudente") String idStudente) throws ClassNotFoundException, SQLException{
		StudenteService.removeStudentClass(idStudente);
	}
}
