package BookController;


import bookservice.BookService;

public class BookBorrowController {

	public boolean getResult(String bisbn) {
		BookService service = new BookService();
		boolean book = service.getupdate(bisbn);
		return book;
	}

}
