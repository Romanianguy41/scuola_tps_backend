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
	
	public static void updateClass(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().updateClass(classe);
	}
	
	public static void deleteClass(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().deleteClass(classe);
	} 
	
	public static void createClasse(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().createClasse(classe);
	} 
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getClasses());
		System.out.println(getClasses("sezione:'A',sezione:'B'"));
		System.out.println(getClasses("classe:2;sezione:'A'"));
		//createClasse(new Classe(0, 5, "CIF"));
		System.out.println(getClasses());
		System.out.println(getClasses("classe:5;sezione:'CIF'"));
	}
}
