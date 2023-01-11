package usercontroller;

import userservice.UserService;

public class UserSignUpController {

	public int getResult(String id, String name, String password, String birth, String tel) {
		UserService service = new UserService();
		int list = service.insert(id, name, password, birth, tel);
		return list;
	}

}
