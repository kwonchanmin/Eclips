package BookController;

import bookservice.BookService;

public class BookAddController {

	public int getResult(String bisbn,String btitle, String bdate, int bpage,int bprice, String bauthor, String btranslator, String bsupplement, String bpublisher) {
		BookService service = new BookService();
		int count = service.insert(bisbn,btitle,bdate,bpage,bprice,bauthor,btranslator,bsupplement,bpublisher);
		return count;
	}

}
