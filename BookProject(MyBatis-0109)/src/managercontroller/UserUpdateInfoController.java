package managercontroller;

import userservice.UserService;

public class UserUpdateInfoController {

	public int getResult(String name, String password, String birth, String tel, String id) {
		UserService service = new UserService();
		int list = service.update(name, password, birth, tel, id);
		return list;
	}

}
