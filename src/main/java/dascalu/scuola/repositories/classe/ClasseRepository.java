package dascalu.scuola.repositories.classe;

import java.sql.PreparedStatement;
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
        query.append("SELECT idClasse, classe, sezione FROM classi");
        try {
            ResultSet res = db.executeQuery(query.toString());
            while (res.next()) {
                classi.add(new Classe(res.getInt("idClasse"),
                        res.getInt("classe"),
                        res.getString("sezione"),
                        new ArrayList<ProfessoreMateria>()
                ));
            }
            System.out.println("\nGET CLASSI:\n eseguita con successo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return classi;
    }

    @Override
    public ArrayList<Classe> getClasses(String search) throws ClassNotFoundException, SQLException {
        MySqlConnector db = new MySqlConnector();
        ArrayList<Classe> classi = new ArrayList<Classe>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT idClasse, classe, sezione FROM classi ");
        String specificationResult = Specification.convertToSQL(search);
        if (!(specificationResult.equals(""))) {
            query.append("WHERE ").append(specificationResult).append(";");
        }
        try {
            PreparedStatement statement = db.startQuery(query.toString());
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                classi.add(new Classe(res.getInt("idClasse"),
                        res.getInt("classe"),
                        res.getString("sezione"),
                        new ArrayList<ProfessoreMateria>()
                ));
            }
            System.out.println("\nGET CLASSI, \nsearch:\n" + search + ": eseguita con successo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return classi;
    }

    @Override
    public void updateClass(Classe classe) throws ClassNotFoundException, SQLException {
        MySqlConnector db = new MySqlConnector();
        StringBuilder query = new StringBuilder();
        query.append("UPDATE classi SET classe=?, sezione=? WHERE idClasse=?");
        try {
            PreparedStatement statement = db.startQuery(query.toString());
            statement.setInt(1, classe.getClasse());
            statement.setString(2, classe.getSezione());
            statement.setInt(3, classe.getIdClasse());

            statement.executeUpdate();
            db.commit();
            System.out.println("\nUPDATE CLASSE:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    @Override
    public void deleteClass(String idClasse) throws ClassNotFoundException, SQLException {
        MySqlConnector db = new MySqlConnector();
        String query = "DELETE FROM classi WHERE idClasse = ?";
        try {
            PreparedStatement statement = db.startQuery(query);
            statement.setString(1, idClasse);

            statement.executeUpdate();
            db.commit();

            System.out.println("\nDELETE CLASSE:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    @Override
    public void createClass(Classe classe) throws ClassNotFoundException, SQLException {
        MySqlConnector db = new MySqlConnector();
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO classi (classe, sezione) VALUES (?, ?)");
        try {
            PreparedStatement statement = db.startQuery(query.toString());
            statement.setInt(1, classe.getClasse());
            statement.setString(2, classe.getSezione());

            statement.executeUpdate();
            db.commit();
            System.out.println("\nCREATE CLASSE:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }
}
