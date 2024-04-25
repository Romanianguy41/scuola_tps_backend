package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Insegna;
import dascalu.scuola.repositories.insegna.InsegnaRepository;

public class InsegnaManager {


	public static ArrayList<Insegna> getInsegnaSoftLoad() throws ClassNotFoundException, SQLException{
		return new InsegnaRepository().getInsegna();	
	}
	
	public static ArrayList<Insegna> getInsegnaSoftLoad(String search) throws ClassNotFoundException, SQLException{
		return new InsegnaRepository().getInsegna(search);
	}
	
	public static ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException{
		ArrayList<Insegna> insegna = new InsegnaRepository().getInsegna();
		
		return insegna ;
	}
	
	public static ArrayList<Insegna> getInsegna(String search) throws ClassNotFoundException, SQLException{
		return new InsegnaRepository().getInsegna(search);
	}
	
	
	public static void updateInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException{
		new InsegnaRepository().updateInsegna(classeProfessore);
	}
	
	public static void deleteInsegna(String classeProfessoreKey) throws ClassNotFoundException, SQLException{
		new InsegnaRepository().deleteInsegna(classeProfessoreKey);
	}
	
	public static void createInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException{
		new InsegnaRepository().createInsegna(classeProfessore);
	}
}
