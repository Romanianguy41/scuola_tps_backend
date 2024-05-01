package dascalu.scuola.repositories.studente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
			 .append("from studenti ");
	    try {
	        ResultSet res = db.executeQuery(query.toString());
	        while (res.next()) {
	            studenti.add(new Studente(res.getInt("idStudente"),
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
	            ));
	        }
	        System.out.println("\n");
	        System.out.println("GET STUDENTI:\n eseguita con successo");
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        db.closeConnection();
	    }

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
		
		System.out.println("\nFIltro");
		System.out.println(query);
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
	         .append(" nome=?,")
	         .append(" cognome=?,")
	         .append(" codFiscale=?,")
	         .append(" luogoNascita=?,")
	         .append(" dataNascita=?,")
	         .append(" indirizzo=?,")
	         .append(" cittadinanza=?,")
	         .append(" CAP=?,")
	         .append(" email=?,")
	         .append(" numeroTelefono=?");
	        query.append(", rifClasse=?");
	    query.append(" where idStudente=?");

	    try {
	    	PreparedStatement statement = db.startQuery(query.toString());
	    	statement.setString(1, student.getNome());
	    	statement.setString(2, student.getCognome());
	    	statement.setString(3, student.getCodiceFiscale().toUpperCase());
	    	statement.setString(4, student.getLuogoNascita());
	    	statement.setDate(5, student.getDataNascita());
	    	statement.setString(6, student.getIndirizzo());
	    	statement.setString(7, student.getCittadinanza());
	    	statement.setInt(8, student.getCAP());
	    	statement.setString(9, student.getEmail());
	    	statement.setString(10, student.getNumeroTelefono());
	    	if (student.getClasse() != null) {
	        	statement.setInt(11, student.getClasse().getIdClasse());
	        } else {
	        	statement.setNull(11, Types.INTEGER);
	        }
	        statement.setInt(12, student.getIdStudente());

	        statement.executeUpdate();
	        db.commit();
	    } catch (SQLException ex) {
	    	 db.rollBack();
		     ex.printStackTrace();
	    } finally {
	    	
	    	db.closeConnection();
	    	System.out.println("\n");
		    System.out.println("UPDATE STUDENTI:\n eseguita con successo");
	    }

	    
	
	}

	@Override
	public void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException {
	    MySqlConnector db = new MySqlConnector();
	    String query = "DELETE FROM studenti WHERE idStudente = ?";
	    try {
	        PreparedStatement statement = db.startQuery(query);
	        statement.setString(1, idStudente);

	        statement.executeUpdate();
	        db.commit();

	        System.out.println("\n");
	        System.out.println("DELETE STUDENTI:\n eseguita con successo");
	    } catch (SQLException ex) {
	        db.rollBack();
	        ex.printStackTrace();
	    } finally {
	        db.closeConnection();
	    }
	}

	@Override
	public void createStudent(Studente student) throws ClassNotFoundException, SQLException{
		 MySqlConnector db = new MySqlConnector();
		    String query = "INSERT INTO studenti (nome, cognome, codFiscale, luogoNascita, indirizzo, "
		    			+ "cittadinanza, CAP, rifClasse, email, dataNascita, numeroTelefono) " +
		                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    try {
		    	PreparedStatement statement = db.startQuery(query);
		        statement.setString(1, student.getNome());
		        statement.setString(2, student.getCognome());
		        statement.setString(3, student.getCodiceFiscale());
		        statement.setString(4, student.getLuogoNascita());
		        statement.setString(5, student.getIndirizzo());
		        statement.setString(6, student.getCittadinanza());
		        statement.setInt(7, student.getCAP());
		        if (student.getClasse() != null) {
		        	statement.setInt(8, student.getClasse().getIdClasse());
		        } else {
		        	statement.setNull(8, Types.INTEGER);
		        }
		        statement.setString(9, student.getEmail());
		        statement.setDate(10, new Date(student.getDataNascita().getTime()));
		        statement.setString(11, student.getNumeroTelefono());
		        statement.executeUpdate();
		        db.commit(); 
		        System.out.println("\n");
		        System.out.println("CREATE STUDENTI:\n eseguita con successo");
		    } catch (SQLException ex) {
		        db.rollBack();
		        ex.printStackTrace();
		    } finally {
		        db.closeConnection();
		    }

	}
	
	@Override
	public void removeStudentClass(String idStudente) throws ClassNotFoundException, SQLException{
		MySqlConnector db = new MySqlConnector();
	    String query = "UPDATE studenti SET rifClasse = NULL WHERE idStudente = ?";
	    try {
	        PreparedStatement statement = db.startQuery(query);
	        statement.setString(1, idStudente);
	        statement.executeUpdate();
	        db.commit();
	        System.out.println("\n");
	        System.out.println("UPDATE STUDENTE CLASSE:\n eseguita con successo");
	    } catch (SQLException ex) {
	        db.rollBack();
	        ex.printStackTrace();
	    } finally {
	        db.closeConnection();
	    }
	}

}
