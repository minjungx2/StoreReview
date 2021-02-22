package org.gogildong.time;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;

public class TimeDAO {
	
	private static final String NAMESPACE = "org.gogildong.time.TimeMapper";
	
	public String getTime() {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getTime");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
