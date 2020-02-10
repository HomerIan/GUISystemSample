package guiSystem;

import java.sql.*;
import java.util.Scanner;

public class addData {
	
	private static Connection conn = null;
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/guisystem?useSSL=false";
			
			conn = DriverManager.getConnection(url,userName,password);	
			
			System.out.println("Enter the Name.");
			String name = in.nextLine();
			
			System.out.println("Enter the Email. ");
			String email = in.nextLine();
			
			addData(name,email);	

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void addData(String name, String email) throws SQLException {
		String query = "INSERT INTO names VALUES (NULL, '"+name+"', '"+email+"');";
		
		Statement state = null;
		state = conn.createStatement();
		state.executeUpdate(query);
		state.close();
		conn.close();
		
	}

}
