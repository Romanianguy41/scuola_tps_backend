package dascalu.scuola.controllers;

import java.sql.SQLException;
import java.util.List;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

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
	public String getInsegna() throws ClassNotFoundException, SQLException {
		return JsonIo.toJson(InsegnaService.getInsegna(), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public String getInsegna(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		return JsonIo.toJson(InsegnaService.getInsegna(search), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createInsegna(String userRequest) throws ClassNotFoundException, SQLException {
		System.out.println(userRequest);
		InsegnaService.createInsegna(userRequest);
	}
	
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public void updateInsegna(String userRequest) throws ClassNotFoundException, SQLException{
		InsegnaService.updateInsegna(userRequest);
	}
	
	@DELETE
	@Path("{idInsegna}")
	public void deleteInsegna(@PathParam("idInsegna") String idInsegna) throws ClassNotFoundException, SQLException {
		InsegnaService.deleteInsegna(idInsegna);
	}
	
	@DELETE
	@Path("professore/{idprofessore}")
	public void deleteInsegnaByProfessor(@PathParam("idprofessore") String idProfessore) throws ClassNotFoundException, SQLException {
		InsegnaService.deleteInsegnaByProfessor(idProfessore);
	}
	
	@DELETE
	@Path("classe/{idClasse}")
	public void deleteInsegnaByClass(@PathParam("idClasse") String idClasse) throws ClassNotFoundException, SQLException {
		InsegnaService.deleteInsegnaByClass(idClasse);
	}
	
	
}
