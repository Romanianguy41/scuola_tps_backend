package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.ProfessoreMateria;

public class ClasseService {

	public static ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		ArrayList<Classe> classi = ClasseManager.getClasses();
		StringBuilder searchString = new StringBuilder(); 
		for(Classe classe : classi) {
			searchString = new StringBuilder();
			searchString.append("rifClasse:")
						.append(classe.getIdClasse());
			ArrayList<Insegna> insegna = InsegnaService.getInsegna(searchString.toString());
			for(Insegna elementoInsegna : insegna) {
				classe.getDocenti().add(new ProfessoreMateria(elementoInsegna.getProfessore(),
										elementoInsegna.getMateria()));
			}
		}
		
		return classi;
	}
	
	public static ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		ArrayList<Classe> classi = ClasseManager.getClasses(search);
		StringBuilder searchString = new StringBuilder(); 
		for(Classe classe : classi) {
			searchString = new StringBuilder();
			searchString.append("rifClasse:")
						.append(classe.getIdClasse());
			ArrayList<Insegna> insegna = InsegnaService.getInsegna(searchString.toString());
			for(Insegna elementoInsegna : insegna) {
				classe.getDocenti().add(new ProfessoreMateria(elementoInsegna.getProfessore(),
										elementoInsegna.getMateria()));
			}
		}
		
		return classi;
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
