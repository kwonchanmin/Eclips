package managerService;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import managerdao.ManagerDAO;
import managetvo.Manager;
import userVO.User;
import userdao.UserConnectPool;
import userdao.UserDAO;

public class ManagerService {

	public ObservableList<Manager> select(String id, String password) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManagerDAO dao = new ManagerDAO(con);
		ObservableList<Manager> list = dao.select(id, password);
		return list;
	}

	public ObservableList<User> select1(String text) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManagerDAO dao = new ManagerDAO(con);
		ObservableList<User> list = dao.select1(text);
		return list;
	}

	public ObservableList<User> deleteid(String deleteid, String searchKeyword) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManagerDAO dao = new ManagerDAO(con);
		int count = dao.delete(deleteid);
		ObservableList<User> list = dao.select1(searchKeyword);
		return list;
	}

	public int update(String name, String password, String birth, String tel, String id) {
		Connection con = null;
		try {
			con = (UserConnectPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ManagerDAO dao = new ManagerDAO(con);
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

	
}
