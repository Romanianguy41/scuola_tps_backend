package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.InsegnaManager;
import dascalu.scuola.models.Insegna;



public class InsegnaService {
	
	public static ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException{
		return InsegnaManager.getInsegna();
	}
	
	public static ArrayList<Insegna> getInsegna(String search) throws ClassNotFoundException, SQLException{
		return InsegnaManager.getInsegna(search);
	}
	
	public static void updateInsegna(String userRequest) throws ClassNotFoundException, SQLException{
		Insegna insegna = JsonIo.toObjects(userRequest, null, Insegna.class);
		InsegnaManager.updateInsegna(insegna);
	}
	
	public static void deleteInsegna(String classeProfessoreKey) throws ClassNotFoundException, SQLException{
		InsegnaManager.deleteInsegna(classeProfessoreKey);
	}
	
	public static void createInsegna(String userRequest) throws ClassNotFoundException, SQLException{
		Insegna insegna = JsonIo.toObjects(userRequest, null, Insegna.class);
		InsegnaManager.createInsegna(insegna);
	}

}
