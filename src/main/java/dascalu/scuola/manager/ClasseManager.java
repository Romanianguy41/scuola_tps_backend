package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Classe;
import dascalu.scuola.repositories.classe.ClasseRepository;

public class ClasseManager {

	public static ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		return new ClasseRepository().getClasses();
	}
	
	public static ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		return new ClasseRepository().getClasses(search);
	}
	
	public static void updateClasse(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().updateClasse(classe);
	}
	
	public static void deleteClasse(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().deleteClasse(classe);
	} 
	
	public static void createClasse(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().createClasse(classe);
	} 
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		deleteClasse(new Classe(8,5,"CIF"));
		System.out.println("\n");
		System.out.println(getClasses("classe:1"));

		
	}
}
