package managercontroller;

import managerService.ManagerService;

public class ManagerUserUpdateController {

	public int getResult(String name, String password, String birth, String tel, String id) {
		ManagerService service = new ManagerService();
		int count = service.update(name,password,birth,tel,id);
		return count;
	}

}
