package org.gogildong.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.utill.PageInfo;
import org.gogildong.store.domain.Store;

public class StoreDAO {
	
	private static final String NAMESPACE = "org.gogildong.store.dao.StoreMapper";
	
	public List<Store> getAll(PageInfo pageInfo){
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectList(NAMESPACE+".getAll", pageInfo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Store getOne(Long sno) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getOne", sno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
/*	public int getRcount(Long sno) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getRcount", sno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}*/
	
	public int getTotal() {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getTotal");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
