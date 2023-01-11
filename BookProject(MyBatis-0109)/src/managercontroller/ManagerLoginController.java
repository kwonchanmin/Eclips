package managercontroller;

import managerService.ManagerService;
import managervo.Manager;

public class ManagerLoginController {

	public Manager getResult(String id, String password) {
		ManagerService service = new ManagerService();
		Manager manager = service.select(id, password);
		return manager;
	}

}
