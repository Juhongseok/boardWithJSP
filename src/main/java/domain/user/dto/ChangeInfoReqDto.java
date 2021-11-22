package domain.user.dto;

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

	public void setId(String id) {
		this.id = id;
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
}
