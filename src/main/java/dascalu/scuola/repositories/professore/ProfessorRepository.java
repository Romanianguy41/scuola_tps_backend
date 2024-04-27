package dascalu.scuola.repositories.professore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.Professore;
import dascalu.scuola.models.ClasseMateria;

public class ProfessorRepository implements ProfessoreInterface {

	@Override
	public ArrayList<Professore> getProfessors() throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Professore> professori = new ArrayList<Professore>();
		StringBuilder query = new StringBuilder();
		query.append("Select idProfessore, nome, cognome, codFiscale, luogoNascita, ")
					.append("dataNascita, indirizzo, email, numeroTelefono, CAP, ")
					.append("cittadinanza ")
					.append("from professori ");
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			professori.add(
					new Professore (res.getInt("idProfessore"),
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
							   new ArrayList<ClasseMateria>()
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET PROFESSORI:\n eseguita con successo");
		
		return professori;

	}

	@Override
	public ArrayList<Professore> getProfessors(String search) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
		ArrayList<Professore> professori = new ArrayList<Professore>();
		StringBuilder query = new StringBuilder();
		query.append("Select idProfessore, nome, cognome, codFiscale, luogoNascita, ")
					.append("dataNascita, indirizzo, email, numeroTelefono, CAP, ")
					.append("cittadinanza ")
					.append("from professori ");
		String specificationResult = Specification.convertToSQL(search);
		if(!(specificationResult.equals(""))) {
			query.append("Where ").append(specificationResult)
				 .append(";");
		}
		ResultSet res = db.executeQuery(query.toString());
		while(res.next()) {
			professori.add(
					new Professore (res.getInt("idProfessore"),
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
							   new ArrayList<ClasseMateria>()
							)
					);
		}
		System.out.println("\n");
		System.out.println("GET PROFESSORI, \nsearch:\n"+search+": eseguita con successo");
		
		return professori;

	}

	@Override
	public void updateProfessor(Professore professor) throws ClassNotFoundException, SQLException  {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("update professori set ")
			 .append(" nome='").append(professor.getNome()).append("',")
			 .append(" cognome='").append(professor.getCognome()).append("',")
			 .append(" codFiscale='").append(professor.getCodiceFiscale()).append("',")
			 .append(" luogoNascita='").append(professor.getLuogoNascita()).append("',")
			 .append(" dataNascita='").append(professor.getDataNascita()).append("',")
			 .append(" indirizzo='").append(professor.getIndirizzo()).append("',")
			 .append(" cittadinanza='").append(professor.getCittadinanza()).append("',")
			 .append(" CAP=").append(professor.getCAP()).append(",")
			 .append(" email='").append(professor.getEmail()).append("',")
			 .append(" numeroTelefono='").append(professor.getNumeroTelefono()).append("' ")
			 .append("where idprofessore=").append(professor.getIdProfessore());
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("UPDATE PROFESSORE:\n eseguita con successo");
	
	}

	@Override
	public void deleteProfessor(String idProfessor) throws ClassNotFoundException, SQLException  {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder();
		query.append("delete from professori where idProfessore=")
		.append(idProfessor);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("DELETE PROFESSORE:\n eseguita con successo");
		
	}

	@Override
	public void createProfessor(Professore professor) throws ClassNotFoundException, SQLException  {
		MySqlConnector db = new MySqlConnector();
		StringBuilder query = new StringBuilder(); 
		query.append("Insert into professori ( nome, cognome, codFiscale, luogoNascita, indirizzo, ")
			 .append("cittadinanza, CAP, email, dataNascita, numeroTelefono) ")
			 .append("values('")
			 .append(professor.getNome()).append("', '")
			 .append(professor.getCognome()).append("','")
			 .append(professor.getCodiceFiscale()).append("','")
			 .append(professor.getLuogoNascita()).append("','")
			 .append(professor.getIndirizzo()).append("','")
			 .append(professor.getCittadinanza()).append("',")
			 .append(professor.getCAP()).append(",'")
			 .append(professor.getEmail()).append("','")
			 .append(professor.getDataNascita()).append("','")
			 .append(professor.getNumeroTelefono()).append("');");
		System.out.println(query);
		db.executeQuery(query.toString());
		System.out.println("\n");
		System.out.println("CREATE PROFESSORE:\n eseguita con successo");

	}

}
