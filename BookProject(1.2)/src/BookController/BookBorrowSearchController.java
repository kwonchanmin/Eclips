package BookController;

import BookVO.Book;
import bookservice.BookService;
import javafx.collections.ObservableList;


public class BookBorrowSearchController {

	public ObservableList<Book> getResult(String borrow) {
		BookService service = new BookService();
		ObservableList<Book> list =  service.select(borrow);
		return list;
	}

}
