package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			
			// -- Ejemplo ejecución de consulta a través de JDBC -- //
		      statement = connection.createStatement(); 
		      String sql = "SELECT * FROM vets"; 
		      ResultSet rs = statement.executeQuery(sql); 
		      while(rs.next()){ 
		             int id = rs.getInt("id"); 
		             String firstName = rs.getString("first_name"); 
		             String lastName = rs.getString("last_name"); 
		 
		             System.out.print("Id: " + id); 
		             System.out.print(", Nombre: " + firstName); 
		             System.out.println(", Apellidos: " + lastName); 
		      } 
		        rs.close(); 
		        
		     // -- Fin de ejemplo ejecución de consulta -- //   
			
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}

}
