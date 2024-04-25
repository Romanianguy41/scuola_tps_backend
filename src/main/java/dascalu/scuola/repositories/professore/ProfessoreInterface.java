package dascalu.scuola.repositories.professore;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Professore;

public interface ProfessoreInterface {

	ArrayList<Professore> getProfessors() throws ClassNotFoundException, SQLException;
	
	ArrayList<Professore> getProfessors(String search) throws ClassNotFoundException, SQLException;
	
	void updateProfessor(Professore professor) throws ClassNotFoundException, SQLException;
	
	void deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException;
	
	void createProfessor(Professore professor) throws ClassNotFoundException, SQLException;
	
}
