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
					.append("cittadinanza ")
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
							   new Classe(res.getInt("rifClasse"))
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET STUDENTI:\n eseguita con successo");
		
		return studenti;

	}

	@Override
	public ArrayList<Studente> getStudents(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		StringBuilder query = new StringBuilder();
		query.append("Select idStudente, nome, cognome, codFiscale, luogoNascita, ")
			 .append("dataNascita, indirizzo, email, numeroTelefono, CAP, rifClasse, ")
			 .append("cittadinanza ")
			 .append("from studenti ");
		
		String specificationResult = Specification.convertToSQL(search);
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
							   new Classe(res.getInt("rifClasse"))
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET STUDENTI, \nsearch:\n"+search+": eseguita con successo");
		
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
			 .append(" email='").append(student.getEmail()).append("',")
			 .append(" numeroTelefono='").append(student.getNumeroTelefono()).append("', ");
		if(student.getClasse()!= null)
			query.append(" rifClasse=").append(student.getClasse().getIdClasse()).append(" ");
			 
		query.append("where idStudente=").append(student.getIdStudente());
		System.out.println(query);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("UPDATE STUDENTI:\n eseguita con successo");
	
	}

	@Override
	public void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException{
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder();
		query.append("delete from studenti where idStudente=")
		.append(idStudente);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("DELETE STUDENTI:\n eseguita con successo");
		
	}

	@Override
	public void createStudent(Studente student) throws ClassNotFoundException, SQLException{
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("Insert into studenti ( nome, cognome, codFiscale, luogoNascita, indirizzo, ")
			 .append("cittadinanza, CAP,");
		if(student.getClasse() != null)	
			query.append("rifClasse,"); 
		
		 query.append("email, dataNascita, numeroTelefono ) ")
			 .append("values('")
			 .append(student.getNome()).append("', '")
			 .append(student.getCognome()).append("','")
			 .append(student.getCodiceFiscale()).append("','")
			 .append(student.getLuogoNascita()).append("','")
			 .append(student.getIndirizzo()).append("','")
			 .append(student.getCittadinanza()).append("',")
			 .append(student.getCAP()).append(",");
			if(student.getClasse() != null) 
				query.append(student.getClasse().getIdClasse()).append(",");
			query.append("'").append(student.getEmail()).append("','")
			 .append(student.getDataNascita()).append("','")
			 .append(student.getNumeroTelefono()).append("');");
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("CREATE STUDENTI:\n eseguita con successo");

	}
	
	@Override
	public void removeStudentClass(Studente student) throws ClassNotFoundException, SQLException{
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update studenti set ")
			 .append(" rifClasse=").append("null").append(" ");
		query.append("where idStudente=").append(student.getIdStudente());
		System.out.println(query);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("UPDATE STUDENTE CLASSE:\n eseguita con successo");
	}

}
