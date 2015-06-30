package fishpond.entity;


public class User extends BaseEntity{

	private static final long serialVersionUID = 8481719811040965090L;

	private int _id;
	private String username;
	private String psword;
	private String phone;
	private String email;
	private int belong;
	
	public User() {}
	
	public User(String username, String password, int belong) {
		super();
		this.username = username;
		this.psword = password;
		this.belong = belong;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsword() {
		return psword;
	}
	public void setPsword(String password) {
		this.psword = password;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBelong() {
		return belong;
	}
	public void setBelong(int belong) {
		this.belong = belong;
	}
}
