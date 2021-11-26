package domain.board.dto;

public class ReadReqDto {
	private int id;
	private String title;
	private String content;
	private String userName;
	private int userId;
	public ReadReqDto(int id, String title, String content, String userName, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userName = userName;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
