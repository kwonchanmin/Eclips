package usersearchcontroller;


import usersurvice.UserService;

public class UserUpdateInfoController {

	
	public int getResult(String name, String password, String birth, String tel, String id) {
		UserService service = new UserService();
		int count = service.update1(name,password,birth,tel,id);
		return count;
	}

}
