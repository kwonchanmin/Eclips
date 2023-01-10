package managerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import managetvo.Manager;
import userVO.User;

public class ManagerDAO {

	Connection con;

	public ManagerDAO(Connection con) {
		super();
		this.con = con;
	}

	public ObservableList<Manager> select(String id, String password) {

		ObservableList<Manager> list = null;
		try {
			StringBuffer loginsql = new StringBuffer();
			loginsql.append("SELECT * ");
			loginsql.append("FROM manager ");
			loginsql.append("WHERE id = ? AND password = ? ");

			PreparedStatement pstmt = con.prepareStatement(loginsql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				Manager manager = new Manager(rs.getString("id"), rs.getString("password"));
				list.add(manager);

			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ObservableList<User> select1(String text) {
		ObservableList<User> list = null;
		try {
			StringBuffer searchusersql = new StringBuffer();
			searchusersql.append("SELECT * ");
			searchusersql.append("FROM users ");
			searchusersql.append("WHERE id LIKE ? ");
			searchusersql.append("ORDER BY id ASC ");

			PreparedStatement pstmt = con.prepareStatement(searchusersql.toString());
			pstmt.setString(1, "%" + text + "%");

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				User user = new User(rs.getString("id"), 
						rs.getString("name"), 
						rs.getString("password"),
						rs.getString("birth"), 
						rs.getString("tel"));
				list.add(user);

			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int delete(String deleteid) {
		int count = 0;
		try {
		StringBuffer deleteusersql = new StringBuffer();
		deleteusersql.append("DELETE  ");
		deleteusersql.append("FROM users ");
		deleteusersql.append("WHERE id = ? ");
		PreparedStatement pstmt = con.prepareStatement(deleteusersql.toString());
		pstmt.setString(1, deleteid);
		count = pstmt.executeUpdate();
		System.out.println("삭제된 row의 수 :" + count);
		if(count == 1) {
			con.commit();
		}else {
			con.rollback();
		}
		pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int upate1(String name, String password, String birth, String tel, String id) {
		int count = 0;
		try {
		StringBuffer userupdatesql = new StringBuffer();
		userupdatesql.append("UPDATE users ");
		userupdatesql.append("SET name = ? , password = ? , birth = ? , tel = ? ");
		userupdatesql.append("WHERE id = ? ");
		PreparedStatement pstmt = con.prepareStatement(userupdatesql.toString());
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setString(3, birth);
		pstmt.setString(4, tel);
		pstmt.setString(5, id);
		count = pstmt.executeUpdate();	
		System.out.println(count);
		pstmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
