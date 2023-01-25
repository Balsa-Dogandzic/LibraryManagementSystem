import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	public static ArrayList<String> addReader(String name, String email, String password, String phoneNumber) {
		ArrayList<String> errors = new ArrayList<String>();
		
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Pattern phoneRegex = Pattern.compile("^(\\d{3}[- .]?){2}\\d{3}$");
		Pattern passwordRegex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
		
		if(name.length() < 3)
			errors.add("Name must be at least 3 characters");
		if(!(emailRegex.matcher(email).matches()))
			errors.add("Email not valid");
		if(!(passwordRegex.matcher(password).matches()))
			errors.add("Password must be 8-20 characters long, and contain digits and upper case and lower case letters.");
		if(!(phoneRegex.matcher(phoneNumber).matches()))
			errors.add("Phone number not valid");
		if (errors.size() == 0) {
			try {
				Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();
				String query = "INSERT INTO reader (name,email,password,phone_number) VALUES ('" + name + "','" + email
						+ "','" + password + "','" + phoneNumber + "')";

				stmt.execute(query);
				return null;

			} catch (SQLException e) {
				errors.add("Connection with server failed");
				return errors;
			}
		}
		return errors;
		
	}

	public static ArrayList<String> addWorker(String username, String password) {
		//Checks if a password contains upper case, lower case and digits
		ArrayList<String> errors = new ArrayList<String>();
		Pattern passwordRegex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
		
		if(!(passwordRegex.matcher(password).matches()))
			errors.add("Password must be 8-20 characters long, and contain digits and upper case and lower case letters.");
		if(username.length() < 3)
			errors.add("Username must be at least 3 characters long");
		if(errors.size() == 0) {
			try {
				Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();
				String query = "INSERT INTO employee (username,password) VALUES ('" + username + "','" + password + "')";

				stmt.execute(query);
				return null;

			} catch (SQLException e) {
				errors.add("Connection with server failed.");
				return errors;
			}
		}
		return errors;
		

	}

}
