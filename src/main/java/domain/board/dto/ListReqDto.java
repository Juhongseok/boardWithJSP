package domain.board.dto;

public class ListReqDto {
	private int id;
	private String title;
	private String userName;
	private int readCount;
	private int pageNumber;
	private int size;
	
	public ListReqDto(int id, String title, String userName, int readCount, int pageNumber, int size) {
		this.id = id;
		this.title = title;
		this.userName = userName;
		this.readCount = readCount;
		this.pageNumber = pageNumber;
		this.size = size;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
