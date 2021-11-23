package domain.user.dto;

//회원정보 수정 데이터 전송 모델
public class ChangeInfoReqDto {
	private String id;
	private String password;
	private String address;
	
	public ChangeInfoReqDto(String id, String password, String address) {
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
