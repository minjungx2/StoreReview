package org.gogildong.common.utill;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {
	
	private boolean prev;
	private boolean next;
	private int start;
	private int end;
	private PageInfo pageInfo;
	private int total;
	
	public PageMaker(PageInfo pageInfo, int total) {
		
		this.total = total;
		this.pageInfo = pageInfo;
		
		int currentPage = pageInfo.getPage();
		
		int tempEnd = currentPage + 2;
		
		this.start = currentPage - 2;
		
		if(currentPage < 3) {
			this.start = 1;
		}
		
		int realEnd = (int)(Math.ceil(total/10.0));
		
		end = realEnd < tempEnd ? realEnd : tempEnd;
		
		prev = start > 1;
		
		if(end * pageInfo.getPerSheet() < total) {
			next = true;
		}else {
			next = false;
		}
	}

}
