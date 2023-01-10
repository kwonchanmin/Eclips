package managercontroller;

import javafx.collections.ObservableList;
import managerService.ManagerService;
import userVO.User;

public class ManagerUserDeleteController {

	public ObservableList<User> getResult(String deleteid, String searchKeyword) {
		ManagerService service = new ManagerService();
		ObservableList<User> list = service.deleteid(deleteid,searchKeyword);
		return list;
	}

}
