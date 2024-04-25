package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.manager.StudenteManager;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Studente;

public class StudenteService {

	public static ArrayList<Studente> getStudentes() throws ClassNotFoundException, SQLException {
		ArrayList<Studente> studenti = StudenteManager.getStudents();
		
		for(int i = 0; i < studenti.size(); i++) {
			StringBuilder searchClasse = new StringBuilder();
			searchClasse.append("idClasse:");
			searchClasse.append(studenti.get(i).getClasse().getIdClasse());
			Classe classe = ClasseManager.getClasses(searchClasse.toString()).get(0);
			studenti.get(i).setClasse(classe);
		}
		
		return studenti;
	}
	
	public static ArrayList<Studente> getStudentes(String search) throws ClassNotFoundException, SQLException {
		ArrayList<Studente> studenti = StudenteManager.getStudents();
		
		for(int i = 0; i < studenti.size(); i++) {
			StringBuilder searchClasse = new StringBuilder();
			searchClasse.append("idClasse:");
			searchClasse.append(studenti.get(i).getClasse().getIdClasse());
			Classe classe = ClasseManager.getClasses(searchClasse.toString()).get(0);
			studenti.get(i).setClasse(classe);
		}
		return studenti;
	}
	
	public static String updateClass(String userRequest) throws ClassNotFoundException, SQLException{
		Studente studente = JsonIo.toObjects(userRequest, null, Studente.class);
		StudenteManager.updateStudent(studente);
		return "Done";
	}
	
	public static String deleteClass(String idStudente) throws ClassNotFoundException, SQLException{
		StudenteManager.deleteStudent(idStudente);
		return "Done";
	} 
	
	public static String createClass(String userRequest) throws ClassNotFoundException, SQLException{
		
		Studente Studente = JsonIo.toObjects(userRequest, null, Studente.class);
		StudenteManager.createStudent(Studente);
		return "Done";
	} 
	
}
