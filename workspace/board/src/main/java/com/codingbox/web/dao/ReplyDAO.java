package com.codingbox.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.codingbox.web.dto.ReplyDTO;
import com.codingbox.web.mybatis.SqlMapConfig;

public class ReplyDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public ReplyDAO() {
		sqlSession = factory.openSession(true);
	}
	
	
	public boolean addReply(ReplyDTO rdto) {
		boolean result = false;
		
		if (sqlSession.insert("Reply.addReply",rdto)==1) {
			result=true;
		}
		
		return result;
	}
}
