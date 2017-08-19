
package com.kranthi.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Kranthi Poturaju
 * @version 1.0
 * @since Feb 29, 2016 - 3:08:39 PM
 */
public class MySQLStoredProcedure {

	public static void main(String[] args) {
		getAllEmployees();
		getEmployeeById();
	}

	private static void getEmployeeById() {
		ResultSet rs = null;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		String getDBUSERCursorSql = "{call EMP_SELECTBYID(?,?,?) }";
		try {
			dbConnection = getConnection();
			try {
				callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
				callableStatement.setInt(1, 2);
				callableStatement.executeUpdate();
				final String respCode = callableStatement.getString(2);
				final String respDesc = callableStatement.getString(3);
				System.out.println("=> respCode: " + respCode);
				System.out.println("=> respDesc: " + respDesc);

				rs = callableStatement.getResultSet();
				System.out.println("\n\nEMP_ID\tEMP_NM\tEMP_DOB\tEMP_DOJ\tEMP_EMAIL");
				while (rs.next()) {
					System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5));
				}
				System.out.println("\n\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getAllEmployees() {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		String getDBUSERCursorSql = "{call EMP_SELECT(?,?) }";
		try {
			dbConnection = getConnection();
			try {
				callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
				callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
				// callableStatement.executeUpdate();
				ResultSet rs = callableStatement.executeQuery();
				final String respCode = callableStatement.getString(1);
				final String respDesc = callableStatement.getString(2);
				System.out.println("=> respCode: " + respCode);
				System.out.println("=> respDesc: " + respDesc);

				// rs = callableStatement.getResultSet();
				System.out.println("\n\nEMP_ID\tEMP_NM\tEMP_DOB\tEMP_DOJ\tEMP_EMAIL");
				while (rs.next()) {
					System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5));
				}
				System.out.println("\n\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		String url = "jdbc:mysql://localhost:3306/";
		String db = "test";
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		dbConnection = DriverManager.getConnection(url + db, "root", "admin");
		return dbConnection;
	}
}
