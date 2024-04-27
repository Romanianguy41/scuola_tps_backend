package dascalu.scuola.repositories.insegna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;

public class InsegnaRepository implements InsegnaInterface {

	@Override
	public ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Insegna> classiProfessori = new ArrayList<Insegna>();
		StringBuilder query = new StringBuilder();
		query.append("Select idInsegna, rifClasse, rifProfessore, materia ")
		.append("from insegna");
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			classiProfessori.add(
					new Insegna(res.getInt("idInsegna"),
							   new Classe (res.getInt("rifClasse")),
							   new Professore(res.getInt("rifProfessore")),
							   res.getString("materia")
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET INSEGNA:\n eseguita con successo");
		return classiProfessori;
	}

	@Override
	public ArrayList<Insegna> getInsegna(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Insegna> classiProfessori = new ArrayList<Insegna>();
		StringBuilder query = new StringBuilder();
		query.append("Select idInsegna, rifClasse, rifProfessore, materia ")
		.append("from insegna ");
		String specificationResult = Specification.convertToSQL(search);
		if(!(specificationResult.equals(""))) {
			query.append("Where ").append(specificationResult)
					.append(";");			
		}
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			classiProfessori.add(
					new Insegna(res.getInt("idInsegna"),
							   new Classe (res.getInt("rifClasse")),
							   new Professore(res.getInt("rifProfessore")),
							   res.getString("materia")
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET INSEGNA, \nsearch:\n"+search+": eseguita con successo");
		return classiProfessori;
	}

	@Override
	public void updateInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update insegna set rifClasse=").append(classeProfessore.getClasse().getIdClasse())
					.append(",rifProfessore=").append(classeProfessore.getProfessore().getIdProfessore()).append(", ")
					.append("materia='").append(classeProfessore.getMateria()).append("' ")
					.append("where idInsegna=").append(classeProfessore.getIdInsegna());
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("UPDATE INSEGNA:\n eseguita con successo");
		
	}

	@Override
	public void deleteInsegna(String classeProfessoreKey) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("delete from insegna where idInsegna=")
			.append(classeProfessoreKey);
		System.out.println(query);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("DELETE INSEGNA:\n eseguita con successo");
		

	}

	@Override
	public void createInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("Insert into insegna ( rifClasse, rifProfessore, materia) ")
			 .append("values(")
			 .append(classeProfessore.getClasse().getIdClasse()).append(", ")
			 .append(classeProfessore.getProfessore().getIdProfessore()).append(", '")
			 .append(classeProfessore.getMateria()).append("');");
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("CREATE INSEGNA:\n eseguita con successo");

	}

}
