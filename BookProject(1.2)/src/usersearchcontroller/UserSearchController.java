package usersearchcontroller;

import javafx.collections.ObservableList;
import userVO.User;
import usersurvice.UserService;

public class UserSearchController {

	public ObservableList<User> getResult(String id, String password) {
		UserService service = new UserService();
		ObservableList<User> list = service.select(id,password);
		return list;
	}

}
