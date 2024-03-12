package com.codingbox.web.servlet;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.ReplyDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = new ActionForward();
		
		ReplyDAO rdao = new ReplyDAO();
		
		int replynum;
		int boardnum;
		
		boardnum = Integer.parseInt(request.getParameter("boardnum"));
		replynum = Integer.parseInt(request.getParameter("replynum"));
		
		
		if(rdao.deleteReply(replynum)) {
			forward.setRedirect(true);
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
		}
		
		rdao.deleteReply(replynum);
		
		return forward;
		
	}

}
