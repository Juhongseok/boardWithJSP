package domain.board.dto;

import java.util.List;

public class ListPageReqDto {
	private int total;
	private int currentPage;
	private List<ListReqDto> content;
	private int totalPage;
	private int startPage;
	private int endPage;
	
	public ListPageReqDto(int total, int currentPage, List<ListReqDto> content, int size) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if(total == 0) {
			totalPage = 0;
			startPage = 0;
			endPage = 0;
		}else {
			totalPage = total/size;
			if(total%size >0)
				totalPage++;
			
			int modVal = currentPage%5;
			startPage = currentPage/5*5+1;
			
			if(modVal ==0)
				startPage-=5;
			endPage = startPage+4;
			
			if(endPage > totalPage) {
				endPage = totalPage;
			}
		}
	}
	
	public boolean hasNoList() {
		return total==0;
	}
	public boolean hasList() {
		return total>0;
	}
	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<ListReqDto> getContent() {
		return content;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
	
	
}
