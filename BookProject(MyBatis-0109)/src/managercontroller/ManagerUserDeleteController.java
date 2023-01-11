package managercontroller;

import java.util.List;

import Use.vo.UserVO;
import managerService.ManagerService;

public class ManagerUserDeleteController {

	public List<UserVO> getResult(String deleteid, String searchKeyword) {
		ManagerService service = new ManagerService();
		List<UserVO> list = service.deleteid(deleteid, searchKeyword);
		return list;
	}

}
