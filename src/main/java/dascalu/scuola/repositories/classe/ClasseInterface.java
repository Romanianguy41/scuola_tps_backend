package dascalu.scuola.repositories.classe;
import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Classe;


public interface ClasseInterface {
	
	ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException;
	
	ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException;
	
	void updateClasse(Classe classe) throws ClassNotFoundException, SQLException;
	
	void deleteClasse(Classe classe) throws ClassNotFoundException, SQLException;
	
	void createClasse(Classe classe) throws ClassNotFoundException, SQLException;
	

	
}
