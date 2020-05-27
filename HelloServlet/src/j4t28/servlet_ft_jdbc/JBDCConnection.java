package j4t28.servlet_ft_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDCConnection {
	public static void main(String[] args) {
		try {
			Connection con = getJDBCConnection();
			System.out.println(con);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+" "+rs.getString(4)+" "+rs.getFloat(5));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/hello";
		final String user = "root";
		final String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
