package gr.hua.dit.transfer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://sql7.freesqldatabase.com/sql7269863?useSSL=false"; //alekos database
        String user = "sql7269863";
        String pass = "9ZeYAX3eJf";

        try {
                System.out.println("Connecting to database: " + jdbcUrl);
                Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
                System.out.println("Connection success");

        } catch (Exception e) {
                e.printStackTrace();
        }

	}

}
