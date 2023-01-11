package BookController;

import java.util.List;
import book.vo.BookVO;
import bookservice.BookService;


public class BookSearchController {

	public List<BookVO> getResult(String text) {

		BookService service = new BookService();
		List<BookVO> list = service.select(text);
		return list;
	}

}
