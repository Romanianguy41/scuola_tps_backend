package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Studente;
import dascalu.scuola.repositories.studente.StudenteRepository;

public class StudenteManager {
	public static ArrayList<Studente> getStudents() throws ClassNotFoundException, SQLException{
		ArrayList<Studente> studenti = new StudenteRepository().getStudents();
		for(int i = 0; i < studenti.size(); i++) {
			if(studenti.get(i).getClasse() != null) {
				StringBuilder searchClasse = new StringBuilder();
				searchClasse.append("idClasse:");
				searchClasse.append(studenti.get(i).getClasse().getIdClasse());
				ArrayList<Classe> result = ClasseManager.getClasses(searchClasse.toString());
				if(result.size()!=0)
					studenti.get(i).setClasse(result.get(0));
			}
		}
		return studenti;
	}
	
	public static ArrayList<Studente> getStudents(String search) throws ClassNotFoundException, SQLException{
		ArrayList<Studente> studenti = new StudenteRepository().getStudents(search);
		for(int i = 0; i < studenti.size(); i++) {
			if(studenti.get(i).getClasse() != null) {
				StringBuilder searchClasse = new StringBuilder();
				searchClasse.append("idClasse:");
				searchClasse.append(studenti.get(i).getClasse().getIdClasse());
				ArrayList<Classe> result = ClasseManager.getClasses(searchClasse.toString());
				if(result.size()!=0)
				studenti.get(i).setClasse(result.get(0));
			}
		}
		return studenti;
	}
	
	public static void updateStudent(Studente student) throws ClassNotFoundException, SQLException{
		System.out.println("\nPOST JSON");
		System.out.println(student);
		new StudenteRepository().updateStudent(student);
	}
	
	public static void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException{
		new StudenteRepository().deleteStudent(idStudente);
	}
	
	public static void createStudent(Studente student) throws ClassNotFoundException, SQLException{
		new StudenteRepository().createStudent(student);
	}
	
	public static void removeStudentClass(String idStudente) throws ClassNotFoundException, SQLException{
		new StudenteRepository().removeStudentClass(idStudente);
	}


}
