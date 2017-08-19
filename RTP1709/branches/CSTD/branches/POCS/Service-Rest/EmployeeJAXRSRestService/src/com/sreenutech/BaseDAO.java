package com.sreenutech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class BaseDAO {
	public Connection getConnection() throws Exception{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
			                                   "user=root&password=root");
		return con;
	}
	
	public void closeConnection(Connection con){
		try {
			if(con != null && !con.isClosed()){
				con.close();
			}
		} catch (SQLException e) {
			SRLogUtil.logTrace("BaseDAO", "closeConnection", e);
		}
	}
}
