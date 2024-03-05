package com.codingbox.web.servlet;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.ReplyDAO;
import com.codingbox.web.dto.ReplyDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		ReplyDAO rdao = new ReplyDAO();
		ReplyDTO rdto = new ReplyDTO();
		
		

		
		String username=request.getParameter("username");
		String replycontents = request.getParameter("replycontents"); 
		String password = request.getParameter("password");
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		
		
		rdto.setBoardnum(boardnum);
		rdto.setUsername(username);
		rdto.setReplycontents(replycontents);
		rdto.setPassword(password);
		
		if(rdao.addReply(rdto)) {
			forward.setRedirect(true);
			forward.setPath("/board/BoardView.bo?boardnum=" + boardnum);
		}
		
		return forward;

	
	
	
	}

}
