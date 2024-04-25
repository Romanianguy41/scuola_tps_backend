package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ProfessoreManager;
import dascalu.scuola.models.Professore;
import dascalu.scuola.models.Studente;


public class ProfessoreService {
	public static ArrayList<Professore> getProfessors() throws ClassNotFoundException, SQLException{
		return ProfessoreManager.getProfessors();
	}
	
	public static ArrayList<Professore> getProfessors(String search) throws ClassNotFoundException, SQLException{
		return ProfessoreManager.getProfessors(search);
		
	}
	
	public static String updateProfessor(String userRequest) throws ClassNotFoundException, SQLException{
		Professore professor = JsonIo.toObjects(userRequest, null, Professore.class);
		ProfessoreManager.updateProfessor(professor);
		return "Done";
	}
	
	public static String deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException{
		ProfessoreManager.deleteProfessor(idProfessor);
		return "Done";
	}
	
	public static String createProfessor(String userRequest) throws ClassNotFoundException, SQLException{
		Professore professor = JsonIo.toObjects(userRequest, null, Professore.class);
		ProfessoreManager.createProfessor(professor);
		return "Done";
	}
}
