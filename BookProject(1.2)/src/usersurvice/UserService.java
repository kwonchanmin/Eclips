package usersurvice;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;

import userVO.User;
import userdao.UserConnectPool;
import userdao.UserDAO;

public class UserService {

	public ObservableList<User> select(String id, String password) {
		
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UserDAO dao = new UserDAO(con);
		ObservableList<User> list = dao.select(id,password);
		return list;
	}

	public int insert(String id, String name, String password, String birth, String tel) {
		
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UserDAO dao = new UserDAO(con);
	
	
		int count = dao.insert(id,name,password,birth,tel);
		if(count == 1 ) {
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

	public int update(String id, String name, String password, String birth, String tel) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UserDAO dao = new UserDAO(con);
		int count = dao.update(id,name,password,birth,tel);
		return count;
	}

	public int update1(String name, String password, String birth, String tel, String id) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UserDAO dao = new UserDAO(con);
		int count = dao.upate1(name,password,birth,tel,id);
	
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

	public int delete(String id) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UserDAO dao = new UserDAO(con);
		int count = dao.delete(id);
	
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
}
