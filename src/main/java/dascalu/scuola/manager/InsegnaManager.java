package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;
import dascalu.scuola.repositories.insegna.InsegnaRepository;

public class InsegnaManager {

	public static ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException{
		ArrayList<Insegna> insegna = new InsegnaRepository().getInsegna();
		for(int i = 0; i < insegna.size(); i++) {
			StringBuilder search = new StringBuilder();
			search.append("idClasse:");
			search.append(insegna.get(i).getClasse().getIdClasse());
			Classe classe = ClasseManager.getClasses(search.toString()).get(0);
			insegna.get(i).setClasse(classe);
			search = new StringBuilder();
			search.append("idProfessore:");
			search.append(insegna.get(i).getProfessore().getIdProfessore());
			Professore professore = ProfessoreManager.getProfessors(search.toString()).get(0);
			insegna.get(i).setProfessore(professore);
		}
		return insegna;
	}
	
	public static ArrayList<Insegna> getInsegna(String search) throws ClassNotFoundException, SQLException{
		ArrayList<Insegna> insegna = new InsegnaRepository().getInsegna(search);
		for(int i = 0; i < insegna.size(); i++) {
			StringBuilder searchString = new StringBuilder();
			searchString.append("idClasse:");
			searchString.append(insegna.get(i).getClasse().getIdClasse());
			Classe classe = ClasseManager.getClasses(searchString.toString()).get(0);
			insegna.get(i).setClasse(classe);
			searchString = new StringBuilder();
			searchString.append("idProfessore:");
			searchString.append(insegna.get(i).getProfessore().getIdProfessore());
			Professore professore = ProfessoreManager.getProfessors(searchString.toString()).get(0);
			insegna.get(i).setProfessore(professore);
		}
		return insegna;
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
