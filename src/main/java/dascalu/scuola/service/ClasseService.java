package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

import dascalu.scuola.manager.ClasseManager;
import dascalu.scuola.manager.InsegnaManager;
import dascalu.scuola.manager.StudenteManager;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.ProfessoreMateria;

public class ClasseService {

	public static String getClasses() throws ClassNotFoundException, SQLException {
		
		return JsonIo.toJson(getClassesInterno(null), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	}
	
	public static String getClasses(String search) throws ClassNotFoundException, SQLException {

		return JsonIo.toJson(getClassesInterno(search), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	}
	
	public static void updateClass(String userRequest) throws ClassNotFoundException, SQLException{
		Classe classe = JsonIo.toObjects(userRequest, null, Classe.class);
		ClasseManager.updateClass(classe);
	}
	
	public static void deleteClass(String idClasse) throws ClassNotFoundException, SQLException{
		StudenteManager.removeClassReference(idClasse);
		InsegnaManager.deleteInsegnaByClass(idClasse);
		ClasseManager.deleteClass(idClasse);
	} 
	
	public static void createClass(String userRequest) throws ClassNotFoundException, SQLException{
		
		Classe classe = JsonIo.toObjects(userRequest, null, Classe.class);
		ClasseManager.createClass(classe);
	} 
	
	private static ArrayList<Classe> getClassesInterno(String search) throws ClassNotFoundException, SQLException{
		ArrayList<Classe> classi;
		if(search != null) {
			classi = ClasseManager.getClasses(search);
		}else {
			classi = ClasseManager.getClasses();
		}
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

}
