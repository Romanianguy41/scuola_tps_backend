package dascalu.scuola.repositories.classe;
import java.util.ArrayList;

import dascalu.scuola.models.Classe;


public interface ClasseInterface {

	ArrayList<Classe> getClasses();
	
	ArrayList<Classe> getClasses(String search);
	
	void updateClass(Classe classe);
	
	void deleteClass(Classe classe);
	
	void createClasse(Classe classe);
	

	
}
