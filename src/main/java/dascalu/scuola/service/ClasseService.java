package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.models.Classe;

public class ClasseService {

	public static ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		return ClasseManager.getClasses();
	}
	
	public static ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		return ClasseManager.getClasses(search);
	}
	
	public static String updateClass(String userRequest) throws ClassNotFoundException, SQLException{
		Classe classe = JsonIo.toObjects(userRequest, null, Classe.class);
		ClasseManager.updateClass(classe);
		return "Done";
	}
	
	public static String deleteClass(String idClasse) throws ClassNotFoundException, SQLException{
		ClasseManager.deleteClass(idClasse);
		return "Done";
	} 
	
	public static String createClass(String userRequest) throws ClassNotFoundException, SQLException{
		
		Classe classe = JsonIo.toObjects(userRequest, null, Classe.class);
		ClasseManager.createClass(classe);
		return "Done";
	} 

}
