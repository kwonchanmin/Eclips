package managerService;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import Use.mybatis.MyBatisConnectionFactory;
import Use.vo.UserVO;
import managerdao.ManagerDAO;
import managervo.Manager;

public class ManagerService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public Manager select(String id, String password) {

		ManagerDAO dao = new ManagerDAO(factory);
		Manager manager = dao.select(id, password);
		return manager;
	}

	public List<UserVO> select1(String text) {

		ManagerDAO dao = new ManagerDAO(factory);
		List<UserVO> list = dao.select1(text);
		return list;
	}

	public List<UserVO> deleteid(String deleteid, String searchKeyword) {

		ManagerDAO dao = new ManagerDAO(factory);
		int count = dao.delete(deleteid);
		List<UserVO> list = dao.select1(searchKeyword);
		return list;
	}

}
