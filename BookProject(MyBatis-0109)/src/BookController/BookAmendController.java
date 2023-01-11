package BookController;

import bookservice.BookService;

public class BookAmendController {

	public int getResult(String btitle, String bdate, int bpage, int bprice, String bauthor, String btranslator,
			String bsupplement, String bpublisher, String bisbn) {
		BookService service = new BookService();
		int count = service.update(btitle, bdate, bpage, bprice, bauthor, btranslator, bsupplement, bpublisher, bisbn);
		return count;
	}

}
