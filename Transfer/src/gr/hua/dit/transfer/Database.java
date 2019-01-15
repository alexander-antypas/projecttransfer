package gr.hua.dit.transfer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static void main(String[] args) {
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	     } catch (ClassNotFoundException e) {
	            System.out.println(" Unable to load driver. ");
	     }
		 String url = "jdbc:mysql://db4free.net:3306/transfer_1";
	     String username = "it21672";
	     String password = "hzyo3ag6";
	     
	     try {
	    	 Connection conn = DriverManager.getConnection(url, username, password);
	             System.out.println(" Connection Established. ");
	        } catch (Exception e) {
	            System.out.println(" Error connecting to database:  "
	                    + e);
	        }

	}
}
