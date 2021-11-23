package domain.board.dto;

import java.sql.Timestamp;

public class WriteReqDto {
	private String title;
	private String content;
	private int readCount;
	private int userId;
	
	
	public WriteReqDto(String title, String content, int readCount, int userId) {
		super();
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.userId = userId;
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
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
