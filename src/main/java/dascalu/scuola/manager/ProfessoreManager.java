package dascalu.scuola.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.scuola.models.Classe;
import dascalu.scuola.models.ClasseMateria;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;
import dascalu.scuola.repositories.professore.ProfessorRepository;

public class ProfessoreManager {
	public static ArrayList<Professore> getProfessors() throws ClassNotFoundException, SQLException{
		ArrayList<Professore> professori = new ProfessorRepository().getProfessors();
		StringBuilder search = new StringBuilder();
		for(int i = 0; i < professori.size(); i++)
		{
			search = new StringBuilder();
			search.append("rifProfessore:").append(professori.get(i).getIdProfessore());
			ArrayList<Insegna> insegna = InsegnaManager.getInsegnaSoftLoad(search.toString());
			for(int j = 0; j < insegna.size(); j++) {
				search = new StringBuilder();
				search.append("idClasse:");
				search.append(insegna.get(j).getClasse().getIdClasse());
				Classe classe = ClasseManager.getClasses(search.toString()).get(0);
				ClasseMateria classeMateria = new ClasseMateria(classe, insegna.get(j).getMateria());
				professori.get(i).getInsegna().add(classeMateria);
			}
		}
		return professori;
		
	}
	
	public static ArrayList<Professore> getProfessors(String search) throws ClassNotFoundException, SQLException{
		ArrayList<Professore> professori = new ProfessorRepository().getProfessors(search);
		StringBuilder searchString = new StringBuilder();
		for(int i = 0; i < professori.size(); i++)
		{
			searchString = new StringBuilder();
			searchString.append("rifProfessore:").append(professori.get(i).getIdProfessore());
			ArrayList<Insegna> insegna = InsegnaManager.getInsegnaSoftLoad(searchString.toString());
			for(int j = 0; j < insegna.size(); j++) {
				searchString = new StringBuilder();
				searchString.append("idClasse:");
				searchString.append(insegna.get(j).getClasse().getIdClasse());
				Classe classe = ClasseManager.getClasses(searchString.toString()).get(0);
				ClasseMateria classeMateria = new ClasseMateria(classe, insegna.get(j).getMateria());
				professori.get(i).getInsegna().add(classeMateria);
			}
		}
		return professori;
		
	}
	
	public static void updateProfessor(Professore professor) throws ClassNotFoundException, SQLException{
		new ProfessorRepository().updateProfessor(professor);
	}
	
	public static void deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException{
		new ProfessorRepository().deleteProfessor(idProfessor);
	}
	
	public static void createProfessor(Professore professor) throws ClassNotFoundException, SQLException{
		new ProfessorRepository().createProfessor(professor);
	}
}
