package userdao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import userVO.User;

public class UserDAO {

	Connection con;
	
	int count = 0;
	public UserDAO() {
		
	}
	
	public UserDAO(Connection con) {
		super();
		this.con = con;
	}

	public ObservableList<User> select(String id, String password) {
		
		ObservableList<User> list = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * ");
			sql.append("FROM users ");
			sql.append("WHERE id = ? AND password = ?  ");			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next()) {
				User user = new User(rs.getString("id"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getString("birth"),
						rs.getString("tel"));
				list.add(user);
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("password"));
			}
			pstmt.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return list;
	}


	public int insert(String id, String name, String password, String birth, String tel) {
		
		int result = 0;
	
		try {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users ");
		sql.append("VALUES (?,?,?,?,?) ");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, password);
		pstmt.setString(4, birth);
		pstmt.setString(5, tel);
		result = pstmt.executeUpdate();
		System.out.println("추가된 row 수 : " + result);
		pstmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int update(String id, String name, String password, String birth, String tel) {
		int count = 0;
		try {
		StringBuffer Userupdatesql = new StringBuffer();
		Userupdatesql.append("UPDATE users ");
		Userupdatesql.append("SET name = ? , password = ? , birth = ? , TEL = ? ");
		Userupdatesql.append("WHERE id = ? ");
		PreparedStatement pstmt = con.prepareStatement(Userupdatesql.toString());
		count = pstmt.executeUpdate();
		System.out.println("변경된 row의 수 :"+ count);
		pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
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

	public int delete(String id) {
		int count = 0;
		try {
		StringBuffer deleteusersql = new StringBuffer();
		deleteusersql.append("DELETE ");
		deleteusersql.append("FROM users ");
		deleteusersql.append("WHERE id = ? ");
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(deleteusersql.toString());
		pstmt.setString(1, id);
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
