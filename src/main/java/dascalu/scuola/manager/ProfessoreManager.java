package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Professore;
import dascalu.scuola.repositories.professore.ProfessorRepository;

public class ProfessoreManager {
	public static ArrayList<Professore> getProfessors() throws ClassNotFoundException, SQLException{
		return new ProfessorRepository().getProfessors();
	}
	
	public static ArrayList<Professore> getProfessors(String search) throws ClassNotFoundException, SQLException{	
		return new ProfessorRepository().getProfessors(search);	
	}
	
	public static void updateProfessor(Professore professor) throws ClassNotFoundException, SQLException{
		new ProfessorRepository().updateProfessor(professor);
	}
	
	public static void deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException{
		new ProfessorRepository().deleteProfessor(idProfessor);
	}
	
	public static void createProfessor(Professore professor) throws ClassNotFoundException, SQLException{
		new ProfessorRepository().createProfessor(professor);
	}
}
