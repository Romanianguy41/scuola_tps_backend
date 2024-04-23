package dascalu.scuola.repositories.professore;

import java.util.ArrayList;

import dascalu.scuola.models.Professore;

public interface ProfessoreInterface {

	ArrayList<Professore> getProfessors();
	
	ArrayList<Professore> getProfessors(String search);
	
	void updateProfessor(Professore professor);
	
	void deleteProfessor(Professore professor);
	
	void createProfessor(Professore professor);
	
}
