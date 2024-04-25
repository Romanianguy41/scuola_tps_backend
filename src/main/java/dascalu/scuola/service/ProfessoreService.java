package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ProfessoreManager;
import dascalu.scuola.models.ClasseMateria;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;


public class ProfessoreService {
	public static ArrayList<Professore> getProfessors() throws ClassNotFoundException, SQLException{
		ArrayList<Professore> professori = ProfessoreManager.getProfessors();
		StringBuilder searchString = new StringBuilder(); 
		for(Professore professore : professori) {
			searchString = new StringBuilder();
			searchString.append("rifProfessore:")
						.append(professore.getIdProfessore());
			ArrayList<Insegna> insegna = InsegnaService.getInsegna(searchString.toString());
			for(Insegna elementoInsegna : insegna) {
				professore.getInsegna().add(new ClasseMateria(elementoInsegna.getClasse(),
										elementoInsegna.getMateria()));
			}
		}
		
		return professori;
	}
	
	public static ArrayList<Professore> getProfessors(String search) throws ClassNotFoundException, SQLException{
		ArrayList<Professore> professori = ProfessoreManager.getProfessors(search);
		StringBuilder searchString = new StringBuilder(); 
		for(Professore professore : professori) {
			searchString = new StringBuilder();
			searchString.append("rifProfessore:")
						.append(professore.getIdProfessore());
			ArrayList<Insegna> insegna = InsegnaService.getInsegna(searchString.toString());
			for(Insegna elementoInsegna : insegna) {
				professore.getInsegna().add(new ClasseMateria(elementoInsegna.getClasse(),
										elementoInsegna.getMateria()));
			}
		}
		
		return professori;
		
	}
	
	public static String updateProfessor(String userRequest) throws ClassNotFoundException, SQLException{
		Professore professor = JsonIo.toObjects(userRequest, null, Professore.class);
		ProfessoreManager.updateProfessor(professor);
		return "Done";
	}
	
	public static String deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException{
		ProfessoreManager.deleteProfessor(idProfessor);
		return "Done";
	}
	
	public static String createProfessor(String userRequest) throws ClassNotFoundException, SQLException{
		Professore professor = JsonIo.toObjects(userRequest, null, Professore.class);
		ProfessoreManager.createProfessor(professor);
		return "Done";
	}
}
