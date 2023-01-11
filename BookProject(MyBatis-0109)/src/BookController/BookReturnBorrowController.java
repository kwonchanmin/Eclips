package BookController;

import bookservice.BookService;

public class BookReturnBorrowController {

	public int getResult(String bisbn) {
		BookService service = new BookService();
		int count = service.getupdate1(bisbn);
		return count;
	}

}
