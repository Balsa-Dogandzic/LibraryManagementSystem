import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class getMethods {

	public boolean getWorkers(String username) {
		boolean status = false;
		try (Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();

				PreparedStatement preparedStatement = con
						.prepareStatement("select * from employee where username = ?")) {

			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			status = rs.next();

		} catch (Exception e) {
			// process sql exception
			System.out.println(e);
		}
		return status;
	}
}
