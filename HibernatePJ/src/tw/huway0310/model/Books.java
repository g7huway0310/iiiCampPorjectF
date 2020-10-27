package tw.huway0310.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	private String bookname;
	private int id;
	private String author;
	private int price;
	private BooksDetail bookDetail;

	@Column(name = "bookname")
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	//Annotation寫在Get方法上
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "AUTHOR")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "PRICE")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public Books(String bookname, String author, int price, BooksDetail bookDetail) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.bookDetail = bookDetail;
	}
	
	
	public Books() {
		super();
	}

	//fetchLAZY
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "books",cascade = CascadeType.ALL)
	public BooksDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BooksDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	
}
