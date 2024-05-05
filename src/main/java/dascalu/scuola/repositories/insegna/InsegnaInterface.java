package dascalu.scuola.repositories.insegna;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Insegna;

public interface InsegnaInterface {

	ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException;
	
	ArrayList<Insegna> getInsegna(String s) throws ClassNotFoundException, SQLException;
	
	void createInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException;
	
	void updateInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException;
	
	void deleteInsegna(String classeProfessoreKey) throws ClassNotFoundException, SQLException;
	
	void deleteInsegnaByProfessor(String professoreKey) throws ClassNotFoundException, SQLException;
	
	void deleteInsegnaByClass(String classesKey) throws ClassNotFoundException, SQLException;
}
