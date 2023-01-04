import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	public boolean validate(String username, String password) {
		boolean status = false;
		try (

				Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();

				PreparedStatement preparedStatement = con
						.prepareStatement("select * from employee where username = ? and password = ? ")) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			// process sql exception
			System.out.println(e);
		}
		return status;
	}
}
