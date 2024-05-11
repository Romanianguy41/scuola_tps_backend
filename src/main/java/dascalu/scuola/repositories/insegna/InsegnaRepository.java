package dascalu.scuola.repositories.insegna;

import java.sql.PreparedStatement;
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
    public ArrayList<Insegna> getInsegna() throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        ArrayList<Insegna> classiProfessori = new ArrayList<Insegna>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT idInsegna, rifClasse, rifProfessore, materia ")
                .append("FROM insegna");
        try {
            ResultSet res = db.executeQuery(query.toString());
            while (res.next()) {
                classiProfessori.add(new Insegna(res.getInt("idInsegna"),
                                                  new Classe(res.getInt("rifClasse")),
                                                  new Professore(res.getInt("rifProfessore")),
                                                  res.getString("materia")));
            }
            System.out.println("\nGET INSEGNA:\n eseguita con successo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return classiProfessori;
    }

    @Override
    public void createInsegna(Insegna classeProfessore) throws SQLException, ClassNotFoundException {
    	MySqlConnector db = new MySqlConnector();
    	String query = "INSERT INTO insegna (rifClasse, rifProfessore, materia) VALUES (?, ?, ?)";
    	try {
    		PreparedStatement statement = db.startQuery(query);
    		statement.setInt(1, classeProfessore.getClasse().getIdClasse());
    		statement.setInt(2, classeProfessore.getProfessore().getIdProfessore());
    		statement.setString(3, classeProfessore.getMateria());
    		
    		statement.executeUpdate();
    		db.commit();
    		System.out.println("\nCREATE INSEGNA:\n eseguita con successo");
    	} catch (SQLException ex) {
    		db.rollBack();
    		ex.printStackTrace();
    	} finally {
    		db.closeConnection();
    	}
    }
    
    @Override
    public ArrayList<Insegna> getInsegna(String search) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        ArrayList<Insegna> classiProfessori = new ArrayList<Insegna>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT idInsegna, rifClasse, rifProfessore, materia ")
                .append("FROM insegna ");
        String specificationResult = Specification.convertToSQL(search);
        if (!(specificationResult.equals(""))) {
            query.append("WHERE ").append(specificationResult).append(";");
        }
        System.out.println("\nFIltro");
        System.out.println(query);
        try {
            ResultSet res = db.executeQuery(query.toString());
            while (res.next()) {
                classiProfessori.add(new Insegna(res.getInt("idInsegna"),
                                                  new Classe(res.getInt("rifClasse")),
                                                  new Professore(res.getInt("rifProfessore")),
                                                  res.getString("materia")));
            }
            System.out.println("\nGET INSEGNA, \nsearch:\n" + search + ": eseguita con successo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return classiProfessori;
    }

    @Override
    public void updateInsegna(Insegna classeProfessore) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        StringBuilder query = new StringBuilder();
        query.append("UPDATE insegna SET rifClasse=?, rifProfessore=?, materia=? WHERE idInsegna=?");
        try {
            PreparedStatement statement = db.startQuery(query.toString());
            statement.setInt(1, classeProfessore.getClasse().getIdClasse());
            statement.setInt(2, classeProfessore.getProfessore().getIdProfessore());
            statement.setString(3, classeProfessore.getMateria());
            statement.setInt(4, classeProfessore.getIdInsegna());

            statement.executeUpdate();
            db.commit();
            System.out.println("\nUPDATE INSEGNA:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    @Override
    public void deleteInsegna(String classeProfessoreKey) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        String query = "DELETE FROM insegna WHERE idInsegna = ?";
        try {
            PreparedStatement statement = db.startQuery(query);
            statement.setString(1, classeProfessoreKey);

            statement.executeUpdate();
            db.commit();

            System.out.println("\nDELETE INSEGNA:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }


	@Override
	public void deleteInsegnaByProfessor(String professoreKey) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
        String query = "DELETE FROM insegna WHERE rifProfessore = ?";
        try {
            PreparedStatement statement = db.startQuery(query);
            statement.setString(1, professoreKey);
            System.out.println(query);
            System.out.println(professoreKey);
            statement.executeUpdate();
            db.commit();

            System.out.println("\nDELETE INSEGNA rifPROF:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
		
	}

	@Override
	public void deleteInsegnaByClass(String classeKey) throws ClassNotFoundException, SQLException {
		MySqlConnector db = new MySqlConnector();
        String query = "DELETE FROM insegna WHERE rifClasse = ?";
        try {
            PreparedStatement statement = db.startQuery(query);
            statement.setString(1, classeKey);

            statement.executeUpdate();
            db.commit();

            System.out.println("\nDELETE INSEGNA rifPROF:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
		
	}
}
