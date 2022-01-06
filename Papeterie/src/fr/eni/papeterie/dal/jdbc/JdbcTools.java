package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import fr.eni.papeterie.dal.Settings;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
	private static Connection con = null;

	public static Connection getConnection() throws SQLException {
		if(con == null) {
			con = DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("user"), Settings.getProperty("password"));
		}
		return con;
	}
	public static void closeConnection() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
