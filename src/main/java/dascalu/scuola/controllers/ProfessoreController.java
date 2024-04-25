package dascalu.scuola.controllers;

import java.sql.SQLException;
import java.util.List;

import dascalu.scuola.models.Professore;
import dascalu.scuola.service.ProfessoreService;
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

@Path("professore")
public class ProfessoreController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professore> getProfessors() throws ClassNotFoundException, SQLException {
		return ProfessoreService.getProfessors();
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professore> getProfessors(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return ProfessoreService.getProfessors(search);	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createProfessor(String userRequest) throws ClassNotFoundException, SQLException {
		return ProfessoreService.createProfessor(userRequest);
	}
	
	@DELETE
	@Path("{idprofessore}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProfessor(@PathParam("idprofessore") String idprofessore) throws ClassNotFoundException, SQLException {
		return ProfessoreService.deleteProfessor(idprofessore);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateProfessors(String userRequest) throws ClassNotFoundException, SQLException{
		return ProfessoreService.updateProfessor(userRequest);
	}
}