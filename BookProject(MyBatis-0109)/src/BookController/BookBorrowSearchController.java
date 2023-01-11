package BookController;

import book.vo.BookVO;
import bookservice.BookService;

public class BookBorrowSearchController {

	public BookVO getResult(String borrow) {
		BookService service = new BookService();
		BookVO book = service.select1(borrow);
		return book;
	}

}
