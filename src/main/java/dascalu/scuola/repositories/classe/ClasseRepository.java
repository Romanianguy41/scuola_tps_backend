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
		String querry = "Select idClasse, classe, sezione"
						+ "from classe";
		ResultSet res = db.executeQuery(querry);
		while(res.next()) {
			classi.add(
					new Classe(res.getInt("idClasse"),
							   res.getInt("classe"),
							   res.getString("sezione")
							)
					);
		}
		System.out.println(classi.get(0));
		return classi;
	}

	@Override
	public ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Classe> classi = new ArrayList<Classe>();
		String querry = "Select idClasse, classe, sezione"
				+ "from classe"  
				+ "Where " + Specification.convertToSQL(search);
		ResultSet res = db.executeQuery(querry);
		while(res.next()) {
			classi.add(
					new Classe(res.getInt("idClasse"),
							   res.getInt("classe"),
							   res.getString("sezione")
							)
					);
		}
		System.out.println(classi.get(0));
		return classi;
	}

	@Override
	public void updateClass(Classe classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClass(Classe classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createClasse(Classe classe) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		String search = "sezione:'A',sezione:'B'";
		String querry = Specification.convertToSQL(search);
		System.out.println(querry);
		String fullQuerry = "select * from classe where " + querry;
		System.out.println(fullQuerry);
		ResultSet rs = db.executeQuery(fullQuerry);
		while (rs.next()) {
				
			Classe classe = new Classe(
					rs.getInt("idClasse"),
					rs.getInt("classe"),
					rs.getString("sezione")
			);
			System.out.println(classe);
		}
	}
}
