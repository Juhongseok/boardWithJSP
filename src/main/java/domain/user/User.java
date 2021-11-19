package domain.user;

public class User {
	private int id;
	private String memberId;
	private String password;
	private String address;
	private Role role;
	
	public User(int id, String memberId, String password, String address, Role role) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.password = password;
		this.address = address;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
