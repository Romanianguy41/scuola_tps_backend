package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.models.Classe;

public class ClasseService {

	public static ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		return ClasseManager.getClasses();
	}
	
	public static ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		return ClasseManager.getClasses(search);
	}
	
	public static void updateClasse(Classe classe) throws ClassNotFoundException, SQLException{
		ClasseManager.updateClasse(classe);
	}
	
	public static void deleteClasse(Classe classe) throws ClassNotFoundException, SQLException{
		ClasseManager.deleteClasse(classe);
	} 
	
	public static void createClasse(Classe classe) throws ClassNotFoundException, SQLException{
		ClasseManager.createClasse(classe);
	} 

}
