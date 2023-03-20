package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

public class Prova {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=root" ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			Statement st = conn.createStatement() ;
			
			String sql = "SELECT corso, punti, data "
					+ "FROM voto" ;
			
			ResultSet res = st.executeQuery(sql) ;
			
			List<Voto> voti = new ArrayList<>() ;
			
			while(res.next()) {
				String corso = res.getString("corso") ;
				int punti = res.getInt("punti") ;
				
//				System.out.println(corso + " = " + punti) ;
				
				Voto v = new Voto(corso, punti, null) ;
				voti.add(v);
			}
			
			conn.close() ;
			
			
			System.out.println(voti) ;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
