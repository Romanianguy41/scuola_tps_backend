package dascalu.scuola.controllers;

import java.sql.Date;
import java.sql.SQLException;

import dascalu.scuola.service.StudenteService;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Studente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
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
	
	@PUT
	@Path("allClasse/{idClasse}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void removeClassReference(@PathParam("idClasse") String idClasse) throws ClassNotFoundException, SQLException{
		StudenteService.removeStudentClass(idClasse);
	}
	
	@POST
	@Path("form")
	public void addStudentForum(@FormParam("nomeStudente") String nome, @FormParam("cognomeStudente") String cognome,
			@FormParam("codFiscale") String codFiscale, @FormParam("luogoNascita") String luogoNascita,
			@FormParam("dataNascita") Date data, @FormParam("email") String email,
			@FormParam("numeroTelefono") String numeroTelefono, @FormParam("indirizzo") String indirizzo,
			@FormParam("CAP") int CAP, @FormParam("cittadinanza") String cittadinanza) throws ClassNotFoundException, SQLException {
		System.out.println("get");
		StudenteService.createStudenteFromForum(new Studente(0,nome,cognome,codFiscale,luogoNascita,data,indirizzo,cittadinanza,CAP,
													email,numeroTelefono, null));
	}
}
