package dascalu.scuola.repositories.classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.ProfessoreMateria;

public class ClasseRepository implements ClasseInterface {

	@Override
	public ArrayList<Classe> getClasses() throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Classe> classi = new ArrayList<Classe>();
		StringBuilder query = new StringBuilder();
		query.append("Select idClasse, classe, sezione ")
					.append("from classi");
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			classi.add(
					new Classe(res.getInt("idClasse"),
							   res.getInt("classe"),
							   res.getString("sezione"),
							   new ArrayList<ProfessoreMateria>()
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET CLASSI:\n eseguita con successo");
		return classi;
	}

	@Override
	public ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Classe> classi = new ArrayList<Classe>();
		StringBuilder query = new StringBuilder();
		query.append("Select idClasse, classe, sezione ")
					.append("from classi ");
					
		String specificationResult = Specification.convertToSQL(search);
		if(!(specificationResult.equals(""))) {
			query.append("Where ").append(specificationResult)
					.append(";");			
		}
		System.out.println(query);
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			classi.add(
					new Classe(res.getInt("idClasse"),
							   res.getInt("classe"),
							   res.getString("sezione"),
							   new ArrayList<ProfessoreMateria>()
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET CLASSI, \nsearch:\n"+search+": eseguita con successo");
		return classi;
	}

	@Override
	public void updateClass(Classe classe) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update classi set classe=").append(classe.getClasse() )
					.append(",sezione='").append(classe.getSezione()).append("'")
					.append("where idClasse=").append(classe.getIdClasse());
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("UPDATE CLASSE:\n eseguita con successo");
	}

	@Override
	public void deleteClass(String idClasse) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("delete from classi where idClasse=")
			.append(idClasse);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("DELETE CLASSE:\n eseguita con successo");
		
	}

	@Override
	public void createClass(Classe classe) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("Insert into classi ( classe, sezione) ")
			 .append("values(")
			 .append(classe.getClasse()).append(", '")
			 .append(classe.getSezione()).append("');");
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("CREATE CLASSE:\n eseguita con successo");
	}

}
