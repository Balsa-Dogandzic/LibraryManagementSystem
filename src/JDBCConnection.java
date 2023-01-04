
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JDBCConnection {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
	}
}
