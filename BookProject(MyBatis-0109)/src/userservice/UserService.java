package userservice;

import org.apache.ibatis.session.SqlSessionFactory;
import Use.mybatis.MyBatisConnectionFactory;
import Use.vo.UserVO;
import userdao.UserDAO;

public class UserService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public UserVO select(String id, String password) {

		UserDAO dao = new UserDAO(factory);
		UserVO user = dao.select(id, password);
		return user;
	}

	public int insert(String id, String name, String password, String birth, String tel) {
		UserDAO dao = new UserDAO(factory);
		int list = dao.insert(id, name, password, birth, tel);

		return list;
	}

	public int update(String name, String password, String birth, String tel, String id) {
		UserDAO dao = new UserDAO(factory);
		int list = dao.update(name, password, birth, tel, id);
		return list;
	}

	public int delete(String id) {
		UserDAO dao = new UserDAO(factory);
		int count = dao.delete(id);
		return count;
	}

}
