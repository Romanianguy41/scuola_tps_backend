package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.models.Classe;
import jakarta.json.Json;

public class ClasseService {

	public static ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		return ClasseManager.getClasses();
	}
	
	public static ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		return ClasseManager.getClasses(search);
	}
	
	public static String updateClasse(String userRequest) throws ClassNotFoundException, SQLException{
		Classe classe = JsonIo.toObjects(userRequest, null, Classe.class);
		ClasseManager.updateClasse(classe);
		return "Done";
	}
	
	public static String deleteClasse(String idClasse) throws ClassNotFoundException, SQLException{
		ClasseManager.deleteClasse(idClasse);
		return "Done";
	} 
	
	public static String createClasse(String userRequest) throws ClassNotFoundException, SQLException{
		
		Classe classe = JsonIo.toObjects(userRequest, null, Classe.class);
		ClasseManager.createClasse(classe);
		return "Done";
	} 

}
