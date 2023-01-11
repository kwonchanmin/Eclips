package usercontroller;

import Use.vo.UserVO;
import userservice.UserService;

public class UserSearchController {

	public UserVO getResult(String id, String password) {
		UserService service = new UserService();
		UserVO user = service.select(id, password);
		return user;
	}

}
