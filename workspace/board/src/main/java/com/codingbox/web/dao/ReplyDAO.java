package com.codingbox.web.dao;

import java.util.HashMap;
import java.util.List;

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
	public List<ReplyDTO> viewReply(int boardnum) {
		List<ReplyDTO> rdtoList =
				sqlSession.selectList("Reply.viewReply",boardnum);
		return rdtoList;
	}
	
	public boolean updateReply(String replycontents,int replynum) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("replycontents", replycontents);	
		datas.put("replynum", replynum);	
		
		if(sqlSession.update("Reply.updateReply",datas)==1) {
			result = true;
		}
		return result;
	}


	public boolean deleteReply(int replynum) {
		boolean result = false;
		if(sqlSession.delete("Reply.deleteReply",replynum)==1) {
			result = true;
		}
		return result;
	}
}
