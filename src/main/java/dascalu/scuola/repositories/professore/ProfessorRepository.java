package dascalu.scuola.repositories.professore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dascalu.common.MySqlConnector;
import dascalu.common.Specification;
import dascalu.scuola.models.ClasseMateria;
import dascalu.scuola.models.Professore;

public class ProfessorRepository implements ProfessoreInterface {

    @Override
    public ArrayList<Professore> getProfessors() throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        ArrayList<Professore> professori = new ArrayList<Professore>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT idProfessore, nome, cognome, codFiscale, luogoNascita, ")
                .append("dataNascita, indirizzo, email, numeroTelefono, CAP, ")
                .append("cittadinanza ")
                .append("FROM professori ");
        try {
            ResultSet res = db.executeQuery(query.toString());
            while (res.next()) {
                professori.add(new Professore(res.getInt("idProfessore"),
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
                ));
            }
            System.out.println("\nGET PROFESSORI:\n eseguita con successo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return professori;
    }

    @Override
    public ArrayList<Professore> getProfessors(String search) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        ArrayList<Professore> professori = new ArrayList<Professore>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT idProfessore, nome, cognome, codFiscale, luogoNascita, ")
                .append("dataNascita, indirizzo, email, numeroTelefono, CAP, ")
                .append("cittadinanza ")
                .append("FROM professori ");
        String specificationResult = Specification.convertToSQL(search);
        if (!(specificationResult.equals(""))) {
            query.append("WHERE ").append(specificationResult).append(";");
        }
        try {
            PreparedStatement statement = db.startQuery(query.toString());

            ResultSet res = statement.executeQuery();
            while (res.next()) {
                professori.add(new Professore(res.getInt("idProfessore"),
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
                ));
            }
            System.out.println("\nGET PROFESSORI, \nsearch:\n" + search + ": eseguita con successo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return professori;
    }

    @Override
    public void updateProfessor(Professore professor) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        StringBuilder query = new StringBuilder();
        query.append("UPDATE professori SET nome=?, cognome=?, codFiscale=?, luogoNascita=?, ")
                .append("dataNascita=?, indirizzo=?, cittadinanza=?, CAP=?, email=?, numeroTelefono=? ")
                .append("WHERE idprofessore=?");
        try {
            PreparedStatement statement = db.startQuery(query.toString());
            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getCognome());
            statement.setString(3, professor.getCodiceFiscale());
            statement.setString(4, professor.getLuogoNascita());
            statement.setDate(5, professor.getDataNascita());
            statement.setString(6, professor.getIndirizzo());
            statement.setString(7, professor.getCittadinanza());
            statement.setInt(8, professor.getCAP());
            statement.setString(9, professor.getEmail());
            statement.setString(10, professor.getTelefono());
            statement.setInt(11, professor.getIdProfessore());

            statement.executeUpdate();
            db.commit();
            System.out.println("\nUPDATE PROFESSORE:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    @Override
    public void deleteProfessor(String idProfessor) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        String query = "DELETE FROM professori WHERE idProfessore = ?";
        try {
            PreparedStatement statement = db.startQuery(query);
            statement.setString(1, idProfessor);

            statement.executeUpdate();
            db.commit();

            System.out.println("\nDELETE PROFESSORE:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    @Override
    public void createProfessor(Professore professor) throws SQLException, ClassNotFoundException {
        MySqlConnector db = new MySqlConnector();
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO professori (nome, cognome, codFiscale, luogoNascita, indirizzo, ")
                .append("cittadinanza, CAP, email, dataNascita, numeroTelefono) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        try {
            PreparedStatement statement = db.startQuery(query.toString());
            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getCognome());
            statement.setString(3, professor.getCodiceFiscale());
            statement.setString(4, professor.getLuogoNascita());
            statement.setString(5, professor.getIndirizzo());
            statement.setString(6, professor.getCittadinanza());
            statement.setInt(7, professor.getCAP());
            statement.setString(8, professor.getEmail());
            statement.setDate(9, professor.getDataNascita());
            statement.setString(10, professor.getTelefono());

            statement.executeUpdate();
            db.commit();
            System.out.println("\nCREATE PROFESSORE:\n eseguita con successo");
        } catch (SQLException ex) {
            db.rollBack();
            ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }
}
