package BookController;

import BookVO.Book;
import bookservice.BookService;
import javafx.collections.ObservableList;

public class BookDeleteController {

	public ObservableList<Book> getResult(String deleteISBN, String searchKeyword) {
		BookService service = new BookService();
		ObservableList<Book> list = service.delete(deleteISBN,searchKeyword);
		return list;
	}

}
