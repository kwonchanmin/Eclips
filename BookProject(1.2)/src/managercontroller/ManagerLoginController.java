package managercontroller;

import javafx.collections.ObservableList;
import managerService.ManagerService;
import managetvo.Manager;


public class ManagerLoginController {

	public ObservableList<Manager> getResult(String id, String password) {
		ManagerService service = new ManagerService();
		ObservableList<Manager> list = service.select(id,password);
		return list;
	}

}
