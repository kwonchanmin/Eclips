package BookController;

import java.util.List;

import book.vo.BookVO;
import bookservice.BookService;

public class BookDeleteController {

	public List<BookVO> getResult(String deleteISBN, String searchKeyword) {
		BookService service = new BookService();
		List<BookVO> list = service.delete(deleteISBN, searchKeyword);
		return list;
	}

}
