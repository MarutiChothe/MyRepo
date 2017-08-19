package com.hsbc.intg.customer.info.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.hsbc.intg.customer.info.beans.StatusBlockDao;
import com.mysql.jdbc.CallableStatement;

public class DAOMain {

	public static void main(String[] args) throws SQLException {
		Connection con;
		CallableStatement cs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raj","root","root");
			//ps=con.  ("select * from customerdetails ");
			String sql="{call GetAccountDetails(?,?,?,?,?,?)}";
			cs=(CallableStatement) con.prepareCall(sql);
			//register output parameters with JDBC types
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			//Set values to input parameters
			cs.setString(1,"SBI");
			cs.setString(2, "mbl");
			cs.setInt(3,4572 );
			cs.setString(4, "123");
			boolean b=cs.execute();
			String responseMessage=cs.getString(6);
			String responseCode=cs.getString(5);
			System.out.println("statuscode is"+cs.getString(5));
			System.out.println("status message is"+cs.getString(6));
			//creating StatusBlockDao object
			StatusBlockDao statusBlockDao=new StatusBlockDao();

			statusBlockDao.setResponseCode(responseCode);
			statusBlockDao.setResponseMessage(responseMessage);
			
		
	}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}

		ResultSet rs = cs.executeQuery();
		System.out.println("ResultSet Object"+rs);
		
		while( rs.next() ){
			System.out.println(rs.getString("card_number"));
		}
		

}

}
