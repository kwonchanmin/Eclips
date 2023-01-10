package bookservice;

import java.sql.Connection;
import java.sql.SQLException;

import BookVO.Book;
import bookdao.BookDAO;
import javafx.collections.ObservableList;
import userdao.UserConnectPool;

public class BookService {

	public ObservableList<Book> select(String text) {

		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		ObservableList<Book> list = dao.select(text);
		return list;
	}

	public ObservableList<Book> delete(String deleteISBN, String searchKeyword) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BookDAO dao = new BookDAO(con);

		int count = dao.delete(deleteISBN);
		ObservableList<Book> list = dao.select(searchKeyword);

		if (count == 1 && list != null) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	public boolean getupdate(String bisbn) {

		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BookDAO dao = new BookDAO(con);
		int count = dao.update(bisbn);
		if (count == 1) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;

		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

	}

	public ObservableList<Book> select1(String borrow) {

		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		ObservableList<Book> list = dao.select1(borrow);
		return list;
	}

	public boolean getupdate1(String bisbn) {

		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BookDAO dao = new BookDAO(con);
		int count = dao.update1(bisbn);
		if (count == 1) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;

		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}


	public int insert(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor,
			String btranslator, String bsupplement, String bpublisher) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BookDAO dao = new BookDAO(con);
		int count = dao.insert(bisbn, btitle, bdate, bpage, bprice, bauthor, btranslator, bsupplement, bpublisher);
		if (count == 1) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return count;
	}

	public boolean update(String btitle, String bdate, int bpage, int bprice, String bauthor,
			String btranslator, String bsupplement, String bpublisher , String bisbn) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BookDAO dao = new BookDAO(con);
		int count = dao.update2(btitle,bdate,bpage,bprice,bauthor,btranslator,bsupplement,bpublisher,bisbn);
		if (count == 1) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;

		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}
	
}
