package dascalu.scuola.repositories.studente;

import java.util.ArrayList;

import dascalu.scuola.models.Studente;

public interface studenteInterface {

	ArrayList<Studente> getStudents();
	
	ArrayList<Studente> getStudents(String search);
	
	void updateStudent(Studente Student);
	
	void deleteStudent(Studente Student);
	
	void createStudent(Studente Student);
}
