import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT book.isbn, book.name, book.category, book.price, author.name, book.year_of_publication FROM book\r\n"
					+ "JOIN author ON author.id = book.author_id");
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
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT book.isbn, book.name, book.category, book.price, author.name, book.year_of_publication FROM book\r\n"
					+ "JOIN author ON author.id = book.author_id\r\n"
					+ "WHERE book.isbn != (SELECT book.isbn FROM book JOIN reservation ON reservation.book_id = book.isbn);");
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
}
