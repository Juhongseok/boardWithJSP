package domain.user;
//데이터베이스에서 나온 결과를 담을 모델
public class User {
	private String memberId;
	private String password;
	private String address;
	private String role;
	
	public User(String memberId, String password, String address, String role) {
		this.memberId = memberId;
		this.password = password;
		this.address = address;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
