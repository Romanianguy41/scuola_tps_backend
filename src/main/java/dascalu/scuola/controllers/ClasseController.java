package dascalu.scuola.controllers;


import java.sql.SQLException;
import java.util.List;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

import dascalu.scuola.models.Classe;
import dascalu.scuola.service.ClasseService;
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

@Path("classe")
public class ClasseController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Classe> getClassi() throws ClassNotFoundException, SQLException {
		return ClasseService.getClasses();
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Classe> getClassi(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return ClasseService.getClasses(search);	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createClasse(String userRequest) throws ClassNotFoundException, SQLException {
		return ClasseService.createClasse(userRequest);
	}
	
	@DELETE
	@Path("{idClasse}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteClasse(@PathParam("idClasse") String id) throws ClassNotFoundException, SQLException {
		return ClasseService.deleteClasse(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateClasse(String userRequest) throws ClassNotFoundException, SQLException{
		return ClasseService.updateClasse(userRequest);
	}
}
