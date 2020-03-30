package com.bbs.demorest;
import java.sql.*;


public class Repository {
	
	Connection con = null;
	
	public Repository() {
		String url = "jdbc:mysql://localhost:3306/";
		con = DriverManager.getConnection(url);
	}

}
