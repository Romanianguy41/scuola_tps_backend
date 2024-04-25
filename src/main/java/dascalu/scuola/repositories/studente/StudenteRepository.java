package dascalu.scuola.repositories.studente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.Classe;
import dascalu.scuola.models.Studente;

public class StudenteRepository implements studenteInterface {

	@Override
	public ArrayList<Studente> getStudents() throws SQLException, ClassNotFoundException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		StringBuilder query = new StringBuilder();
		query.append("Select idStudente, nome, cognome, codFiscale, luogoNascita, ")
					.append("dataNascita, indirizzo, email, numeroTelefono, CAP, rifClasse, ")
					.append("cittadinanza")
					.append("from studenti");
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			studenti.add(
					new Studente(res.getInt("idStudente"),
							   res.getString("nome"),
							   res.getString("cognome"),
							   res.getString("codFiscale"),
							   res.getString("luogoNascita"),
							   res.getDate("dataNascita"),
							   res.getString("indirizzo"),
							   res.getString("cittadinanza"),
							   res.getInt("CAP"),
							   res.getString("email"),
							   res.getString("numeroTelefono"),
							   new Classe(res.getInt("rifClasse"), -1, null)
							)
					);
		}
		return studenti;

	}

	@Override
	public ArrayList<Studente> getStudents(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		StringBuilder query = new StringBuilder();
		query.append("Select idStudente, nome, cognome, codFiscale, luogoNascita, ")
			 .append("dataNascita, indirizzo, email, numeroTelefono, CAP, rifClasse ")
			 .append("cittadinanza")
			 .append("from studenti");
		String specificationResult = Specification.convertToSQL(search);
		System.out.println(specificationResult.equals(""));
		if(!(specificationResult.equals(""))) {
			query.append("Where ").append(specificationResult)
				 .append(";");
		}
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			studenti.add(
					new Studente(res.getInt("idStudente"),
							   res.getString("nome"),
							   res.getString("cognome"),
							   res.getString("codFiscale"),
							   res.getString("luogoNascita"),
							   res.getDate("dataNascita"),
							   res.getString("indirizzo"),
							   res.getString("cittadinanza"),
							   res.getInt("CAP"),
							   res.getString("email"),
							   res.getString("numeroTelefono"),
							   new Classe(res.getInt("rifClasse"), -1, null)
							)
					);
		}
		return studenti;
	}

	@Override
	public void updateStudent(Studente student) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update studenti set ")
			 .append(" nome='").append(student.getNome()).append("',")
			 .append(" cognome='").append(student.getCognome()).append("',")
			 .append(" codFiscale='").append(student.getCodiceFiscale()).append("',")
			 .append(" luogoNascita='").append(student.getLuogoNascita()).append("',")
			 .append(" dataNascita='").append(student.getDataNascita()).append("',")
			 .append(" indirizzo='").append(student.getIndirizzo()).append("',")
			 .append(" cittadinanza='").append(student.getCittadinanza()).append("',")
			 .append(" CAP=").append(student.getCAP()).append(",")
			 .append(" rifClasse=").append(student.getClasse().getIdClasse()).append(",")
			 .append(" email='").append(student.getEmail()).append("',")
			 .append(" numeroTelefono='").append(student.getNumeroTelefono()).append("',")
			 .append("where idStudente=").append(student.getIdStudente());
		System.out.println(query.toString());
		db.executeQuery(query.toString());

	}

	@Override
	public void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException{
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder();
		query.append("delete from studenti where idStudente=")
		.append(idStudente);
		db.executeQuery(query.toString());
	}

	@Override
	public void createStudent(Studente student) throws ClassNotFoundException, SQLException{
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("Insert into studenti ( nome, cognome, codFiscale, luogoNascita, indirizzo, ")
			 .append("cittadinanza, CAP, rifClasse, email, numeroTelefono")
			 .append("values(")
			 .append(student.getNome()).append(", '")
			 .append(student.getCognome()).append("','")
			 .append(student.getCodiceFiscale()).append("','")
			 .append(student.getLuogoNascita()).append("','")
			 .append(student.getIndirizzo()).append("','")
			 .append(student.getCittadinanza()).append("',")
			 .append(student.getCAP()).append(",")
			 .append(student.getClasse().getIdClasse()).append(",'")
			 .append(student.getEmail()).append("','")
			 .append(student.getNumeroTelefono()).append("');");
		db.executeQuery(query.toString());

	}

}
