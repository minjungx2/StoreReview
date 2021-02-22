package org.gogildong.time;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests {
	
	private TimeDAO dao;
	
	@Before
	public void ready() {
		
		dao  = new TimeDAO();
		
	}
	
	@Test
	public void testTime() {
		
		log.info(dao.getTime());
		
	}

}
