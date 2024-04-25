package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Studente;
import dascalu.scuola.repositories.studente.StudenteRepository;

public class StudenteManager {
	public static ArrayList<Studente> getStudents() throws ClassNotFoundException, SQLException{
		ArrayList<Studente> studenti = new StudenteRepository().getStudents();
		for(int i = 0; i < studenti.size(); i++) {
			StringBuilder searchClasse = new StringBuilder();
			searchClasse.append("idClasse:");
			searchClasse.append(studenti.get(i).getClasse().getIdClasse());
			Classe classe = ClasseManager.getClasses(searchClasse.toString()).get(0);
			studenti.get(i).setClasse(classe);
		}
		return studenti;
	}
	
	public static ArrayList<Studente> getStudents(String search) throws ClassNotFoundException, SQLException{
		return new StudenteRepository().getStudents(search);
	}
	
	public static void updateStudent(Studente student) throws ClassNotFoundException, SQLException{
		new StudenteRepository().updateStudent(student);
	}
	
	public static void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException{
		new StudenteRepository().deleteStudent(idStudente);
	}
	
	public static void createStudent(Studente student) throws ClassNotFoundException, SQLException{
		new StudenteRepository().createStudent(student);
	}

}
