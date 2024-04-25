package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.manager.StudenteManager;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Studente;

public class StudenteService {

	public static ArrayList<Studente> getStudents() throws ClassNotFoundException, SQLException {
		ArrayList<Studente> studenti = StudenteManager.getStudents();
	
		return studenti;
	}
	
	public static ArrayList<Studente> getStudents(String search) throws ClassNotFoundException, SQLException {
		return  StudenteManager.getStudents(search);
	}
	
	public static String updateStudent(String userRequest) throws ClassNotFoundException, SQLException{
		Studente studente = JsonIo.toObjects(userRequest, null, Studente.class);
		StudenteManager.updateStudent(studente);
		return "Done";
	}
	
	public static String deleteStudent(String idStudente) throws ClassNotFoundException, SQLException{
		StudenteManager.deleteStudent(idStudente);
		return "Done";
	} 
	
	public static String createStudent(String userRequest) throws ClassNotFoundException, SQLException{
		
		Studente Studente = JsonIo.toObjects(userRequest, null, Studente.class);
		StudenteManager.createStudent(Studente);
		return "Done";
	} 
	
}
