package BookController;

import bookservice.BookService;

public class BookBorrowController {

	public int getResult(String bisbn) {
		BookService service = new BookService();
		int count = service.getupdate(bisbn);
		return count;
	}

}
