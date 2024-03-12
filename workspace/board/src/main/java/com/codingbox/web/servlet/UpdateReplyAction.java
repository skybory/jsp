package com.codingbox.web.servlet;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.BoardDAO;
import com.codingbox.web.dao.ReplyDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
	
		ReplyDAO rdao = new ReplyDAO();
		
		int replynum;
		int boardnum;
		
		boardnum = Integer.parseInt(request.getParameter("boardnum"));
		replynum = Integer.parseInt(request.getParameter("replynum"));
		
		String replycontents;
		replycontents = request.getParameter("reply"+replynum);
		
		if(rdao.updateReply(replycontents, replynum)) {
			forward.setRedirect(true);
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
		}
		
		rdao.updateReply(replycontents,replynum);
		
		//해야할 일은 기존의 페이지에서 수정값만 바꾸면 됨. 수정값은 text라서 결국 text만 바꾸고, 나머지는 그대로 가져오면 됨.
		//이건 xml에서 처리 다 했음.
		
		
		//화면은 디테일 받은 view 화면 보여줘야함.
		return forward;
	}

}
