package userdao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Use.vo.UserVO;

public class UserDAO {

	private SqlSessionFactory factory;

	public UserDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	public UserVO select(String id, String password) {

		UserVO user = null;

		UserVO targetUser = new UserVO();
		targetUser.setId(id);
		targetUser.setPassword(password);

		SqlSession session = factory.openSession();

		try {
			user = session.selectOne("Use.selectlogin", targetUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

	public int insert(String id, String name, String password, String birth, String tel) {
		int list = 0;

		UserVO signupuser = new UserVO();
		signupuser.setId(id);
		signupuser.setName(name);
		signupuser.setPassword(password);
		signupuser.setBirth(birth);
		signupuser.setTel(tel);

		SqlSession session = factory.openSession();
		try {
			list = session.insert("Use.insertuser", signupuser);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}

		return list;
	}

	public int update(String name, String password, String birth, String tel, String id) {
		// manager에서 회원정보 수정시 사용 코드
		int list = 0;

		UserVO updateuser = new UserVO();
		updateuser.setName(name);
		updateuser.setPassword(password);
		updateuser.setBirth(birth);
		updateuser.setTel(tel);
		updateuser.setId(id);

		SqlSession session = factory.openSession();
		try {
			list = session.update("Use.updateuser", updateuser);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}

		return list;
	}

	public int delete(String id) {
		int count = 0;

		SqlSession session = factory.openSession();
		try {
			count = session.delete("Use.deleteuser", id);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		return count;
	}

}
