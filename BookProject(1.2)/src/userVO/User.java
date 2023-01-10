package userVO;

public class User {

	private String id;
	private String name;
	private String password;
	private String birth;
	private String tel;
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String name, String password, String birth, String tel) {
		super();
		this.name = name;
		this.password = password;
		this.birth = birth;
		this.tel = tel;
	}


	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public User(String id, String name, String password, String birth, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birth = birth;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	
}
