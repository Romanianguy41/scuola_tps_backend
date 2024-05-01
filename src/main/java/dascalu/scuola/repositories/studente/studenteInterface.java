package dascalu.scuola.repositories.studente;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.scuola.models.Studente;

public interface studenteInterface {

	ArrayList<Studente> getStudents() throws ClassNotFoundException, SQLException;
	
	ArrayList<Studente> getStudents(String search) throws ClassNotFoundException, SQLException;
	
	void updateStudent(Studente Student) throws ClassNotFoundException, SQLException;
	
	void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException;
	
	void createStudent(Studente Student) throws ClassNotFoundException, SQLException;
	
	public void removeStudentClass(String idStudente) throws ClassNotFoundException, SQLException;
}
