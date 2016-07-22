package amazon.api.controller;


import amazon.api.dao.BookDAO;
import amazon.api.dao.BookDAO.BOOKFIELD;
import amazon.api.pojo.Book;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookController {
	
	@RequestMapping("/book")
	public Book fetchById(@RequestParam(value="id", defaultValue="World") String id) {
		System.err.println(id);
		
		Book b = BookDAO.getInstance().fetchOneByField(BookDAO.BOOKFIELD.asin, id);
		
		System.err.println(b);

		return b;
	}
	
	@RequestMapping("/book/all")
	public List<Book> fetchAll() {
		return BookDAO.getInstance().fecthAll();
	}
	
	@RequestMapping("/book/put")
	public void putBook(
			@RequestParam(value="title") String title,
			@RequestParam(value="author") String author,
			@RequestParam(value="date") Long date,
			@RequestParam(value="asin") String asin,
			@RequestParam(value="publisher") String publisher,
			@RequestParam(value="pages") int pages
			) {
		
		BookDAO.getInstance().addBook(title, author, new Date(date), asin, publisher, pages);
	}
	
	@RequestMapping("/book/delete")
	public void putBook(
			@RequestParam(value="id") String id
			) {
		
		BookDAO.getInstance().deleteByField(BOOKFIELD.asin, id);
	}
	
	@RequestMapping("/book/buy")
	public void buy(
			@RequestParam(value="id") String id
			) {
		
		BookDAO.getInstance().buyBook(id);
	}
}
