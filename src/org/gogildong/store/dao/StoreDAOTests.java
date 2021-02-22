package org.gogildong.store.dao;

import java.util.List;

import org.gogildong.common.utill.PageInfo;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Review;
import org.gogildong.store.domain.Store;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class StoreDAOTests {
	
	private StoreDAO storeDAO;
	private ReviewDAO reviewDAO;
	
	@Before
	public void ready() {
		
		storeDAO = new StoreDAO();
		reviewDAO = new ReviewDAO();
		
	}
	
	@Test
	public void testGetAll() {
		
		PageInfo pageInfo = new PageInfo();
		
		pageInfo.setPage(1);
		pageInfo.setPersheet(20);
		
		List<Store> list = storeDAO.getAll(pageInfo);
		
		list.forEach(store -> log.info(storeDAO));
		
	}
	
	/*
	 * @Test public void testGetOne() {
	 * 
	 * Long sno = 1L;
	 * 
	 * Store store = storeDAO.getOne(sno); List<Review> reviewList =
	 * reviewDAO.getReview(sno);
	 * 
	 * log.info(store);
	 * 
	 * reviewList.forEach(review -> log.info(reviewDAO));
	 * 
	 * }
	 */
	//@Test
	/*public void testGetRcount() {
		
		Long sno = 3L;
		
		int rcount = storeDAO.getRcount(sno);
		
		log.info(rcount);
		
	}*/
}
