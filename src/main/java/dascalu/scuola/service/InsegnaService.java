package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.manager.InsegnaManager;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;
import dascalu.scuola.models.Studente;


public class InsegnaService {
	
	public static ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException{
		ArrayList<Insegna> insegna = InsegnaManager.getInsegna();
		
		for(int i = 0; i < insegna.size(); i++) {
			StringBuilder search = new StringBuilder();
			search.append("rifClasse:");
			search.append(insegna.get(i).getClasse().getIdClasse());
			Classe classe = ClasseManager.getClasses(search.toString()).get(0);
			insegna.get(i).setClasse(classe);
			search = new StringBuilder();
			search.append("rifProfessore:");
			search.append(insegna.get(i).getClasse().getIdClasse());
			Professore professore = ProfessoreManager.getProfessors(search.toString()).get(0);
			insegna.get(i).setClasse(Professore);
		}
		return insegna;
	}
	
	public static ArrayList<Insegna> getInsegna(String search) throws ClassNotFoundException, SQLException{

	}
	
	public static void updateInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException{

	}
	
	public static void deleteInsegna(String classeProfessoreKey) throws ClassNotFoundException, SQLException{

	}
	
	public static void createInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException{

	}

}
