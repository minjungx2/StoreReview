package org.gogildong.common.utill;

import lombok.Builder.Default;
import lombok.Getter;

@Getter
public class PageInfo {
	
	@Default
	private int page = 1;
	@Default
	private int perSheet = 6;
	
	private Long sno;
	
	public void setPage(int page) {
		
		if(page < 1) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPersheet(int perSheet) {
		
		if(perSheet > 10) {
			this.perSheet = 10;
			return;
		}
		
		if(perSheet < 6) {
			this.perSheet = 6;
			return;
		}
		
		this.perSheet = perSheet;
	}

	public void setLong(Long sno) {
		this.sno = sno; 
	}
}
