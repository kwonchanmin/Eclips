package bookdao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import book.vo.BookVO;

public class BookDAO {

	private SqlSessionFactory factory;

	public BookDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	public List<BookVO> select(String text) {

		List<BookVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("Use.selectbook", text);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return list;
	}

	public int delete(String deleteISBN) {

		int count = 0;

		SqlSession session = factory.openSession();

		try {
			count = session.delete("Use.deletebook", deleteISBN);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}

		return count;
	}

	public int update(String bisbn) {
		int count = 0;

		SqlSession session = factory.openSession();
		try {
			count = session.update("Use.updateborrow", bisbn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			session.commit();
			session.close();
		}

		return count;
	}

	public BookVO select1(String borrow) {

		BookVO book = null;

		SqlSession session = factory.openSession();
		try {
			book = session.selectOne("Use.selectborrow", borrow);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			session.close();
		}

		return book;
	}

	public int update1(String bisbn) {
		int count = 0;

		SqlSession session = factory.openSession();
		try {
			count = session.update("Use.updateborrow1", bisbn);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}

		return count;
	}

	public int insert(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor,
			String btranslator, String bsupplement, String bpublisher) {

		int count = 0;

		BookVO insertbook = new BookVO();
		insertbook.setBisbn(bisbn);
		insertbook.setBtitle(btitle);
		insertbook.setBdate(bdate);
		insertbook.setBpage(bpage);
		insertbook.setBprice(bprice);
		insertbook.setBauthor(bauthor);
		insertbook.setBtranslator(btranslator);
		insertbook.setBsupplement(bsupplement);
		insertbook.setBpublisher(bpublisher);

		SqlSession session = factory.openSession();
		try {
			count = session.insert("Use.insertbook", insertbook);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return count;
	}

	public int update2(String btitle, String bdate, int bpage, int bprice, String bauthor, String btranslator,
			String bsupplement, String bpublisher, String bisbn) {
		int count = 0;

		BookVO updatebook = new BookVO();
		updatebook.setBtitle(btitle);
		updatebook.setBdate(bdate);
		updatebook.setBpage(bpage);
		updatebook.setBprice(bprice);
		updatebook.setBauthor(bauthor);
		updatebook.setBtranslator(btranslator);
		updatebook.setBsupplement(bsupplement);
		updatebook.setBpublisher(bpublisher);
		updatebook.setBisbn(bisbn);

		SqlSession session = factory.openSession();
		try {
			count = session.update("Use.updatebook2", updatebook);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}

		return count;
	}

}
