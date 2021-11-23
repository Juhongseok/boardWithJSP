package domain.user.dto;

//로그인 데이터 전송 모델
public class LoginReqDto {
	private String id;
	private String password;
	private String address;
	
	public LoginReqDto(String id, String password, String address) {
		this.id = id;
		this.password = password;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
}
