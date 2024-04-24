package dascalu.scuola.repositories.classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.Classe;

public class ClasseRepository implements ClasseInterface {

	@Override
	public ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Classe> classi = new ArrayList<Classe>();
		String query = "Select idClasse, classe, sezione"
						+ "from classi;";
		ResultSet res = db.executeQuery(query);
		while(res.next()) {
			classi.add(
					new Classe(res.getInt("idClasse"),
							   res.getInt("classe"),
							   res.getString("sezione")
							)
					);
		}
		return classi;
	}

	@Override
	public ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Classe> classi = new ArrayList<Classe>();
		String query = "Select idClasse, classe, sezione"
				+ "from classi"  
				+ "Where " + Specification.convertToSQL(search) + ";";
		ResultSet res = db.executeQuery(query);
		while(res.next()) {
			classi.add(
					new Classe(res.getInt("idClasse"),
							   res.getInt("classe"),
							   res.getString("sezione")
							)
					);
		}
		return classi;
	}

	@Override
	public void updateClass(Classe classe) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update classi set classe=").append(classe.getClasse())
					.append("sezione=").append(classe.getSezione())
					.append("where idClasse=").append(classe.getIdClasse());
		db.executeQuery(query.toString());
	}

	@Override
	public void deleteClass(Classe classe) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("delete from classi where idClasse=")
			.append(classe.getIdClasse());
		db.executeQuery(query.toString());
		
	}

	@Override
	public void createClasse(Classe classe) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("Insert into classi (idClasse, classe, sezione) ");
		query.append("values( null,");
		query.append(classe.getIdClasse()).append(" ");
		query.append(classe.getSezione()).append(");");
		db.executeQuery(query.toString());
	}
}
