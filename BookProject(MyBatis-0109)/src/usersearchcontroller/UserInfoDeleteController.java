package usersearchcontroller;

import userservice.UserService;

public class UserInfoDeleteController {

	public int getResult(String id) {
		UserService service = new UserService();
		int count = service.delete(id);
		return count;
	}

}
