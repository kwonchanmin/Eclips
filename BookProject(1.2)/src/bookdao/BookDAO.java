package bookdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BookVO.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BookDAO {
	
	Connection con;
	
	
	public BookDAO(Connection con) {
		super();
		this.con = con;
	}


	public ObservableList<Book> select(String text) {
		
		ObservableList<Book> list = null;
		
		try {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM book ");
		sql.append("WHERE btitle LIKE ? ");
		sql.append("ORDER BY btitle ASC ");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
	
	
		pstmt.setString(1,"%"+ text + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		list = FXCollections.observableArrayList();
		
		while(rs.next()) {
			Book bookvo = new Book(rs.getString("bisbn"),
					rs.getString("btitle"),
					rs.getString("bdate"),
					rs.getInt("bpage"),
					rs.getInt("bprice"),
					rs.getString("bauthor"),
					rs.getString("btranslator"),
					rs.getString("bsupplement"),
					rs.getString("bpublisher"),
					rs.getInt("bborrow"));
			list.add(bookvo);
		}
		rs.close();
		pstmt.close();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return list;
	}


	public int delete(String deleteISBN) {
	int count = 0;
		
		try {
			String deletesql = ("DELETE FROM library.book WHERE bisbn = ? ");
			PreparedStatement pstmt = con.prepareStatement(deletesql);
			pstmt.setString(1 , deleteISBN);
			
				
			count = pstmt.executeUpdate();
			
			System.out.println("삭제한 row의 수 : " + count );
			
			pstmt.close();
					
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		return count;
	}


	public int update(String bisbn) {
		int count = 0;
		
			StringBuffer borrowsql = new StringBuffer();
			borrowsql.append("UPDATE book ");
			borrowsql.append("SET bborrow =1 ");
			borrowsql.append("WHERE bisbn = ? ");
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(borrowsql.toString());
				pstmt.setString(1, bisbn);
			
				count = pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}
	public ObservableList<Book> select1(String borrow) {
		
		ObservableList<Book> list= null;
		
		try {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bborrow ");
		sql.append("FROM book ");
		sql.append("WHERE bborrow = 1 ");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
//		pstmt.setString(1, borrow);
		ResultSet rs = pstmt.executeQuery();
		
	
		
		while(rs.next()) {
			Book book = new Book(rs.getInt("bborrow"));
			list.add(book);
			
			// book 객체가 하나가 만들어졌어 borrow.1
			
			System.out.println(rs.getInt("bborrow"));
		}
		rs.close();
		pstmt.close();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return list;
	}
	public int update1(String bisbn) {
		int count = 0;
		
			StringBuffer borrowsql = new StringBuffer();
			borrowsql.append("UPDATE book ");
			borrowsql.append("SET bborrow = 0 ");
			borrowsql.append("WHERE bisbn = ? ");
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(borrowsql.toString());
				pstmt.setString(1, bisbn);
			
				count = pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}


	public int insert(String bisbn,String btitle, String bdate, int bpage,int bprice, String bauthor, String btranslator, String bsupplement, String bpublisher) {
		int count = 0;
		try {
		StringBuffer addbooksql = new StringBuffer();
		addbooksql.append("INSERT INTO book (bisbn,btitle,bdate,bpage,bprice,bauthor,btranslator,bsupplement,bpublisher) ");
		addbooksql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		PreparedStatement pstmt = con.prepareStatement(addbooksql.toString());
		pstmt.setString(1, bisbn);
		pstmt.setString(2, btitle);
		pstmt.setString(3, bdate);
		pstmt.setInt(4, bpage);
		pstmt.setInt(5, bprice);
		pstmt.setString(6, bauthor);
		pstmt.setString(7, btranslator);
		pstmt.setString(8, bsupplement);
		pstmt.setString(9, bpublisher);
		count = pstmt.executeUpdate();
		System.out.println("추가된 row의 수 :" + count);
		pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}


	public int update2(String btitle, String bdate, int bpage, int bprice, String bauthor,
			String btranslator, String bsupplement, String bpublisher,String bisbn) {
		int count = 0;
		try {
		StringBuffer addbooksql = new StringBuffer();
		addbooksql.append("UPDATE book ");
		addbooksql.append("SET btitle = ? , bdate = ? , bpage = ? , bprice = ? , bauthor = ? , btranslator = ? , bsupplement = ? , bpublisher = ? ");
		addbooksql.append("WHERE bisbn = ? ");
		PreparedStatement pstmt = con.prepareStatement(addbooksql.toString());
		pstmt.setString(1, btitle);
		pstmt.setString(2, bdate);
		pstmt.setInt(3, bpage);
		pstmt.setInt(4, bprice);
		pstmt.setString(5, bauthor);
		pstmt.setString(6, btranslator);
		pstmt.setString(7, bsupplement);
		pstmt.setString(8, bpublisher);
		pstmt.setString(9, bisbn);
		count = pstmt.executeUpdate();
		System.out.println("추가된 row의 수 :" + count);
		pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}



}
