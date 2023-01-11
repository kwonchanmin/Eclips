package managerdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import Use.vo.UserVO;
import managervo.Manager;

public class ManagerDAO {

	private SqlSessionFactory factory;

	public ManagerDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	public Manager select(String id, String password) {

		Manager manager = null;

		Manager loginmanager = new Manager();
		loginmanager.setId(id);
		loginmanager.setPassword(password);

		SqlSession session = factory.openSession();

		try {
			manager = session.selectOne("Use.loginmanager", loginmanager);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return manager;
	}

	public List<UserVO> select1(String text) {

		List<UserVO> list = null;

		SqlSession session = factory.openSession();
		try {
			list = session.selectList("Use.selectuser", text);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return list;
	}

	public int delete(String deleteid) {
		int count = 0;

		SqlSession session = factory.openSession();
		try {
			count = session.delete("Use.deleteuser", deleteid);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		return count;
	}

}
