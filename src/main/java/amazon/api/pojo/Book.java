package amazon.api.pojo;

import java.sql.Date;

public class Book implements IModel{
	
	private String title; 
	private String author;
	private Date publicationDate;
	private String asin;
	private String publisher;
	private int pages;
	private int quantity;

	public Book(String title, String author, 
			Date publicationDate, String asin, String publisher, int pages) {
		
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.asin = asin;
		this.publisher = publisher;
		this.pages = pages;
	}
	
	

	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Book(String title, String author, Date publicationDate, String asin, String publisher, int pages,
			int quantity) {
		
		this(title, author, publicationDate, asin, publisher, pages);
		
		this.quantity= quantity;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asin == null) ? 0 : asin.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (asin == null) {
			if (other.asin != null)
				return false;
		} else if (!asin.equals(other.asin))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publicationDate=" + publicationDate + ", asin=" + asin
				+ ", publisher=" + publisher + ", pages=" + pages + "]";
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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	

}
