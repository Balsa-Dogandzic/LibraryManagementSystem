import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Author {

	private int id;
	private String name;

	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return name;
	}
	
	public static ArrayList<Author> getAuthors() {
		//Returns a list of authors from the database
		ArrayList<Author> authors = new ArrayList<Author>();
		
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, name FROM author");
			Author a;
			
			while(rs.next()) {
				a = new Author(rs.getInt(1), rs.getString(2));
				authors.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authors;
	}

}
