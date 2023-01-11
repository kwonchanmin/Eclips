package managercontroller;

import java.util.List;
import Use.vo.UserVO;
import managerService.ManagerService;

public class ManagerUserSearchController {

	public List<UserVO> getResult(String text) {
		ManagerService service = new ManagerService();
		List<UserVO> list = service.select1(text);
		return list;
	}

}
