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
	
	public static void deleteClass(String idClasse) throws ClassNotFoundException, SQLException{
		new ClasseRepository().deleteClass(idClasse);
	} 
	
	public static void createClass(Classe classe) throws ClassNotFoundException, SQLException{
		new ClasseRepository().createClass(classe);
	} 

}
