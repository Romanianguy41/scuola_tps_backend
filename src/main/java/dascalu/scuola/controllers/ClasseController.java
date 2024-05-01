package dascalu.scuola.controllers;


import java.sql.SQLException;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

import dascalu.scuola.service.ClasseService;
import jakarta.json.bind.annotation.JsonbTransient;
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
	@JsonbTransient
	@Produces(MediaType.TEXT_PLAIN)
	public String getClassi() throws ClassNotFoundException, SQLException {
		return ClasseService.getClasses();
	}
	
	@GET
	@JsonbTransient
	@Path("filter")
	@Produces(MediaType.TEXT_PLAIN)
	public String getClassi(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return ClasseService.getClasses(search);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createClasse(String userRequest) throws ClassNotFoundException, SQLException {
		ClasseService.createClass(userRequest);
	}
	
	@DELETE
	@Path("{idClasse}")
	public void deleteClasse(@PathParam("idClasse") String id) throws ClassNotFoundException, SQLException {
		ClasseService.deleteClass(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateClasse(String userRequest) throws ClassNotFoundException, SQLException{
		ClasseService.updateClass(userRequest);
	}
}
