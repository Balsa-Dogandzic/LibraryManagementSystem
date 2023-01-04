
public class Book {

	private String isbn, name, category;
	private double price;
	private Author author;
	private int year;
	public Book(String isbn, String name, String category, double price, Author author, int year) {
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
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
	
	

}
