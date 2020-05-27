package model;

public class Book {
	private int id;
	private String title;
	private String author;
	private float prices;

	public Book() {
		super();
	}

	public Book(int id) {
		super();
		this.id = id;
	}

	public Book(String title, String author, float prices) {
		super();
		this.title = title;
		this.author = author;
		this.prices = prices;
	}

	public Book(int id, String title, String author, float prices) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.prices = prices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrices() {
		return prices;
	}

	public void setPrices(float prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", prices=" + prices + "]";
	}

}
