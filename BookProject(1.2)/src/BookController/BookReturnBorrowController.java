package BookController;

import bookservice.BookService;

public class BookReturnBorrowController {

	public boolean getResult(String bisbn) {
		BookService service = new BookService();
		boolean book = service.getupdate1(bisbn);
		return book;
	}

}
