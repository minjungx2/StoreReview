package org.gogildong.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.utill.PageInfo;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;

public class ReviewDAO {
	
	private static final String NAMESPACE = "org.gogildong.review.dao.ReviewMapper";
	
	public List<Review> getReview(PageInfo pageInfo){
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectList(NAMESPACE+".getReview", pageInfo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void insertReview(Review review) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			session.insert(NAMESPACE+".insertReview", review);
			session.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTotal(Long sno) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getTotal", sno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public String getImgUrl(Long rno) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getImgUrl", rno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertLike(Like like) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insertLike", like);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".updateLike", like);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void disLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".disLike", like);

			session.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public Like selectLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".selectlike", like);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
