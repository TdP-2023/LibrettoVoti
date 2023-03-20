package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=root" ;
		Connection conn = DriverManager.getConnection(jdbcURL) ;
		return conn;
	}
}
