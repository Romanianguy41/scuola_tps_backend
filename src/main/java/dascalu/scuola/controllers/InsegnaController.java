package dascalu.scuola.controllers;

import java.sql.SQLException;
import java.util.List;

import dascalu.scuola.models.Insegna;
import dascalu.scuola.service.InsegnaService;
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

@Path("insegna")
public class InsegnaController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Insegna> getInsegna() throws ClassNotFoundException, SQLException {
		return InsegnaService.getInsegna();
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Insegna> getInsegna(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return InsegnaService.getInsegna(search);	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createInsegna(String userRequest) throws ClassNotFoundException, SQLException {
		return InsegnaService.createInsegna(userRequest);
	}
	
	@DELETE
	@Path("{idprofessore}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteInsegna(@PathParam("idprofessore") String idprofessore) throws ClassNotFoundException, SQLException {
		return InsegnaService.deleteInsegna(idprofessore);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateInsegna(String userRequest) throws ClassNotFoundException, SQLException{
		return InsegnaService.updateInsegna(userRequest);
	}
}
