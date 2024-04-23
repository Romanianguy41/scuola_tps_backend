package dascalu.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnector {
	//private static final String URL = "jdbc:mysql://2.47.38.54/didattica2324_5cif"; // da casa
		private static final String URL =
		 "jdbc:mysql://10.59.1.50/didattica2324_5cif"; // da scuola
		private static final String USERNAME = "classe5cif2023";
		private static final String PASSWORD = "classe5cif2023";

		private Connection conn;
		private Statement statement;

		public MySqlConnector() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // per verificare la presenza della libreria, altrimenti genera eccezione
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void closeConnection() {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqlEx) {
				}

				statement = null;
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
				statement = conn.createStatement();
				if (statement.execute(query)) {
					resultSet = statement.getResultSet();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}

			return resultSet;
		}
}