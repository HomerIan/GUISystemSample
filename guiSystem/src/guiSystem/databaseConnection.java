package guiSystem;

import java.sql.*;
public class databaseConnection {
	
	private Connection conn;

	public databaseConnection() throws Exception{
		
		String userName = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/guisystem?useSSL=false";
		
		//connect to database
		conn = DriverManager.getConnection(url,userName,password);
		
	}
	public List<customer> getAllcustomer() throws Exception{
		List<customer> customerlist = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM customer");
			
			while(rs.next()) {
				customer tempcustomer = convertRowToCustomer(rs);
				list.add(tempcustomer);
			}
			return list;		
		}
		finally {
			class(stmt,rs);
		}
	}
	
	
}
