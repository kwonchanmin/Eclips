package bookservice;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import Use.mybatis.MyBatisConnectionFactory;
import book.vo.BookVO;
import bookdao.BookDAO;

public class BookService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public List<BookVO> select(String text) {

		BookDAO dao = new BookDAO(factory);
		List<BookVO> list = dao.select(text);
		return list;
	}

	public List<BookVO> delete(String deleteISBN, String searchKeyword) {

		BookDAO dao = new BookDAO(factory);

		int count = dao.delete(deleteISBN);
		List<BookVO> list = dao.select(searchKeyword);

		return list;

	}

	public int getupdate(String bisbn) {

		BookDAO dao = new BookDAO(factory);
		int count = dao.update(bisbn);

		return count;

	}

	public BookVO select1(String borrow) {

		BookDAO dao = new BookDAO(factory);
		BookVO book = dao.select1(borrow);
		return book;
	}

	public int getupdate1(String bisbn) {

		BookDAO dao = new BookDAO(factory);
		int count = dao.update1(bisbn);

		return count;

	}

	public int insert(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor,
			String btranslator, String bsupplement, String bpublisher) {

		BookDAO dao = new BookDAO(factory);
		int count = dao.insert(bisbn, btitle, bdate, bpage, bprice, bauthor, btranslator, bsupplement, bpublisher);

		return count;
	}

	public int update(String btitle, String bdate, int bpage, int bprice, String bauthor, String btranslator,
			String bsupplement, String bpublisher, String bisbn) {

		BookDAO dao = new BookDAO(factory);
		int count = dao.update2(btitle, bdate, bpage, bprice, bauthor, btranslator, bsupplement, bpublisher, bisbn);

		return count;

	}

}
