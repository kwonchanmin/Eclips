package BookController;

import BookVO.Book;
import bookservice.BookService;
import javafx.collections.ObservableList;

public class BookSearchController {

	public ObservableList<Book> getResult(String text) {
		
		BookService service = new BookService();
		ObservableList<Book> list = service.select(text);
		return list;
	}

}
