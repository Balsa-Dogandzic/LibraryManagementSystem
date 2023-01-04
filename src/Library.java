import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Library {

	public void getBooks() {
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM book");
			while (rs.next()) {
				System.out.println(rs.getString(1));	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
