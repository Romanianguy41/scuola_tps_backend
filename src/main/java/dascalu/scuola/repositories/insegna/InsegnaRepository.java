package dascalu.scuola.repositories.insegna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Insegna;
import dascalu.scuola.models.Professore;
import dascalu.scuola.models.ProfessoreMateria;

public class InsegnaRepository implements InsegnaInterface {

	@Override
	public ArrayList<Insegna> getInsegna() throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Insegna> classiProfessori = new ArrayList<Insegna>();
		StringBuilder query = new StringBuilder();
		query.append("Select rifClasse, rifProfessore, materia ")
		.append("from insegna");
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			classiProfessori.add(
					new Insegna(new Classe (res.getInt("rifClasse")),
							   new Professore(res.getInt("rifProfessore")),
							   res.getString("materia")
							)
					);
		}
		return classiProfessori;
	}

	@Override
	public ArrayList<Insegna> getInsegna(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Insegna> classiProfessori = new ArrayList<Insegna>();
		StringBuilder query = new StringBuilder();
		query.append("Select rifClasse, rifProfessore, materia ")
		.append("from insegna ");
		String specificationResult = Specification.convertToSQL(search);
		if(!(specificationResult.equals(""))) {
			query.append("Where ").append(specificationResult)
					.append(";");			
		}
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			classiProfessori.add(
					new Insegna(new Classe (res.getInt("rifClasse")),
							   new Professore(res.getInt("rifProfessore")),
							   res.getString("materia")
							)
					);
		}
		return classiProfessori;
	}

	@Override
	public void updateInsegna(Insegna classeProfessore) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update insegna set rifClasse=").append(classeProfessore.getClasse().getIdClasse())
					.append(",rifProfessore=").append(classeProfessore.getProfessore().getIdProfessore()).append(", ")
					.append("materia='").append(classeProfessore.getMateria()).append("' ")
					.append("where idClasse=").append(classeProfessore.getClasse().getIdClasse()).append(" AND ")
					.append("rifProfessore=").append(classeProfessore.getProfessore().getIdProfessore());
					
		db.executeQuery(query.toString());

	}

	@Override
	public void deleteInsegna(String classeProfessoreKey) throws ClassNotFoundException, SQLException {
		String elements[] = classeProfessoreKey.split("-");
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("delete from classi where rifClasse=")
			.append(elements[0]).append(" AND ")
			.append("rifProfessore=").append(elements[1]).append(" AND ")
			.append("materia='").append(elements[3]).append("');");
		db.executeQuery(query.toString());

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
			

	}

}
