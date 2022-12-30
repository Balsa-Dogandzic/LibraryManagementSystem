
public class Book {

	private String name;
	private int numOfPages;
	private String author;
	
	public Book(String name, int numOfPages, String author) {
		super();
		this.name = name;
		this.numOfPages = numOfPages;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", numOfPages=" + numOfPages + ", author=" + author + "]";
	}
	
}
