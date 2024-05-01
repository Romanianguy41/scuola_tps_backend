package dascalu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnector {
    private static final String URL = "jdbc:mysql://127.0.0.1/tps_scuola";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection conn;
    private PreparedStatement preparedStatement;

    public MySqlConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (preparedStatement != null) {
            try {
            	getConn().setAutoCommit(true);
                preparedStatement.close();
            } catch (SQLException sqlEx) {
            }

            preparedStatement = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    public ResultSet executeQuery(String query) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
        	System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return resultSet;
    }
    
    public PreparedStatement startQuery(String query) throws SQLException {
    	
    	getConn().setAutoCommit(false);
    	getConn().setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    	return getConn().prepareStatement(query);
    	
    }
    
    public void commit() throws SQLException {
    	getConn().commit();
    }
    
    public void rollBack() throws SQLException {
    	getConn().rollback();
    }

    public Connection getConn() {
        return conn;
    }
}
