package domain.user.dto;

//회원가입 데이터 전송 모델
public class JoinReqDto {
	String id;
	String password;
	String address;
	String Role;
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	public String getRole() {
		return Role;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setRole(String role) {
		Role = role;
	}
}
