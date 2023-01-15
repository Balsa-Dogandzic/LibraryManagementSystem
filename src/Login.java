import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

	public static boolean validateEmployee(String username, String password) {
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
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean validateReader(String email, String password) {
		boolean status = false;
		try (

				Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();

				PreparedStatement preparedStatement = con
						.prepareStatement("select * from reader where email = ? and password = ? ")) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public boolean addUser(String name, String email, String password, String phoneNumber) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Pattern p1 = Pattern.compile("^(\\d{3}[- .]?){2}\\d{3}$");

		if (p.matcher(email).matches() && p1.matcher(phoneNumber).matches()) {
			try {
				Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();
				String query = "INSERT INTO reader (name,email,password,phone_number) VALUES ('" + name + "','" + email
						+ "','" + password + "','" + phoneNumber + "')";

				stmt.execute(query);
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return false;
	}

	public boolean addWorker(String username, String password) {

		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			String query = "INSERT INTO employee (username,password) VALUES ('" + username + "','" + password + "')";

			stmt.execute(query);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

}
