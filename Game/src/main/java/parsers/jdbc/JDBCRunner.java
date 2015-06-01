package parsers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCRunner {

	public static List<String> parserBD() {

		Connection cn = null;
		try {
			cn = Connector.getConnection();
			Statement st = null;
			try {
				st = cn.createStatement();
				ResultSet rs = null;
				try {
					rs = st.executeQuery("SELECT name FROM city where country_id=2; ");
					ArrayList<String> sities = new ArrayList<String>();
					while (rs.next()) {
						String city = rs.getString(1);

						sities.add(city);
					}
					if (sities.size() > 0) {
						System.out.println(sities + "MY");
					} else {
						System.out.println("Not found");
					}
					return sities;
				} finally {
					if (rs != null) {
						rs.close();
					} else {
						System.err.println("Ошибка во время чтения из БД");
					}
				}
			} finally {
				if (st != null) {
					st.close();
				} else {
					System.err.println("Statement не создан");
				}
			}
		} catch (SQLException e) {
			System.err.println("DB connection error: " + e);
		} finally {
		}
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				System.err.println("Connection close error: " + e);
			}
		}
		return null;
	}
}
