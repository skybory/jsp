package com.codingbox.web.servlet;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.BoardDAO;
import com.codingbox.web.dto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = new BoardDTO();
		
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		
		bdao.updateReadCount(boardnum);
		request.setAttribute("board", bdao.getDetail(boardnum));

		
		
		
		forward.setRedirect(false);
		forward.setPath("/board/boardview.jsp");
	
		
		// dao 에다 getDetail(boardnum); return boardDTO해줌
		// 리턴되는 대상은 보드DTO에 담겨있는 하나의 dto.
		// 조회 성공시 : 페이지 이동 -> /board/boardview.jsp
		
		return forward;
	}

}
