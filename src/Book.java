import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Book {

	private String isbn, name, category;
	private double price;
	private String author;
	private int year;

	public Book(String isbn, String name, String category, double price, String author, int year) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.category = category;
		this.price = price;
		this.author = author;
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", category=" + category + ", price=" + price + ", author="
				+ author + ", year=" + year + "]";
	}

	public static ArrayList<Book> getAllBooks() {
		// Makes a list of all the books
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT book.isbn, book.name, book.category, book.price, author.name, book.year_of_publication FROM book\r\n"
							+ "JOIN author ON author.id = book.author_id ORDER BY book.name;");
			ArrayList<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				String isbn = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				double price = rs.getDouble(4);
				String author = rs.getString(5);
				int year = rs.getInt(6);
				books.add(new Book(isbn, name, category, price, author, year));
			}
			return books;

		} catch (Exception e) {
			System.out.println("Greska sa bazom.");
			return null;
		}
	}

	public static ArrayList<Book> getFreeBooks() {
		// Makes a list of books that are not reserved
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT book.isbn, book.name, book.category, book.price, author.name, book.year_of_publication FROM book\r\n"
							+ "JOIN author ON author.id = book.author_id\r\n"
							+ "WHERE book.isbn NOT IN (SELECT DISTINCT book.isbn FROM book JOIN reservation ON reservation.book_id = book.isbn)\r\n"
							+ "ORDER BY book.name;");
			ArrayList<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				String isbn = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				double price = rs.getDouble(4);
				String author = rs.getString(5);
				int year = rs.getInt(6);
				books.add(new Book(isbn, name, category, price, author, year));
			}
			return books;

		} catch (Exception e) {
			System.out.println("Greska sa bazom.");
			return null;
		}
	}

	public static boolean addBook(String isbn, String name, String category, double price, int author, int year) {
		Pattern regexISBN = Pattern.compile("^\\d{10,13}$");
		boolean condition = regexISBN.matcher(isbn).matches() && name.length() != 0 && category.length() != 0;
		if (condition) {
			try {
				Connection con = JDBCConnection.getConnection();
				Statement stmt = con.createStatement();
				String query = "INSERT INTO book (isbn,name,category,price,author_id,year_of_publication) VALUES ('"
						+ isbn + "','" + name + "','" + category + "'," + price + "," + author + "," + year + ")";

				stmt.execute(query);
				return true;

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	public static boolean delete(Object id) {
		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			String query = "DELETE FROM `book` WHERE isbn = " + id;

			stmt.execute(query);
			return true;

		} catch (SQLException e) {
			return false;
		}
	}

}
