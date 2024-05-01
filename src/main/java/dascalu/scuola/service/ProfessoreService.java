package dascalu.scuola.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

import dascalu.scuola.manager.ProfessoreManager;
import dascalu.scuola.models.ClasseMateria;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;


public class ProfessoreService {
	public static String getProfessors() throws ClassNotFoundException, SQLException{
	
		return JsonIo.toJson(getProfessoriInterno(null), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	}
	
	public static String getProfessors(String search) throws ClassNotFoundException, SQLException{
		return JsonIo.toJson(getProfessoriInterno(search), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
		
	}
	
	public static void updateProfessor(String userRequest) throws ClassNotFoundException, SQLException{
		Professore professor = JsonIo.toObjects(userRequest, null, Professore.class);
		ProfessoreManager.updateProfessor(professor);
	}
	
	public static void deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException{
		ProfessoreManager.deleteProfessor(idProfessor);
	}
	
	public static void createProfessor(String userRequest) throws ClassNotFoundException, SQLException{
		Professore professor = JsonIo.toObjects(userRequest, null, Professore.class);
		ProfessoreManager.createProfessor(professor);
	}
	
	private static ArrayList<Professore> getProfessoriInterno (String search) throws ClassNotFoundException, SQLException {
		ArrayList<Professore> professori;
		StringBuilder searchString = new StringBuilder(); 
		if(search != null) {
			professori = ProfessoreManager.getProfessors(search);
		}else {
			professori = ProfessoreManager.getProfessors();
		}
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
}
