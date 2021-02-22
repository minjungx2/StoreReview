package org.gogildong.review.dao;

import java.util.List;

import org.gogildong.review.domain.Review;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class ReviewDAOTests {
	
	private ReviewDAO reviewDAO;
	
	@Before
	public void ready() {
		
		reviewDAO = new ReviewDAO();
		
	}
	
	/*
	 * @Test public void testGetReview() {
	 * 
	 * Long sno = 1L;
	 * 
	 * List<Review> list = reviewDAO.getReview(sno);
	 * 
	 * list.forEach(review -> log.info(reviewDAO));
	 * 
	 * }
	 */
	
	@Test
	public void testInsertReview() {
		
		Review review = Review.builder()
				.rno(5L)
				.sno(1L)
				.mid("minjung")
				.context("good")
				.score(4L)
				.img("/upload/aa.jpg")
				.build();
		
		reviewDAO.insertReview(review);
		
		log.info(review);
		
	}

}
