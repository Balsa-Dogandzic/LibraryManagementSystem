import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Reader {

	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	
	public Reader(int id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return id + " " + name;
	}
	
	public static ArrayList<Reader> getReaders() {
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM reader;");
			ArrayList<Reader> readers = new ArrayList<Reader>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phoneNumber = rs.getString(5);
				readers.add(new Reader(id, name, email, phoneNumber));
			}
			return readers;

		} catch (Exception e) {
			System.out.println("Greska sa bazom.");
			return null;
		}
	}
		
}
