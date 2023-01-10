package managercontroller;

import javafx.collections.ObservableList;
import managerService.ManagerService;
import userVO.User;

public class ManagerUserSearchController {

	public ObservableList<User> getResult(String text) {
		ManagerService service = new ManagerService();
		ObservableList<User> list = service.select1(text);
		return list;
	}

}
