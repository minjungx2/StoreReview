package org.gogildong.member.dao;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDAOTests {
	
	private MemberDAO memberDAO;
	
	@Before
	public void ready() {
		
		memberDAO = new MemberDAO();
		
	}
	
	/*
	 * @Test public void testGetMid() {
	 * 
	 * String inputMid = "minjung";
	 * 
	 * memberDAO.getMid(inputMid);
	 * 
	 * log.info(inputMid);
	 * 
	 * }
	 */

}
