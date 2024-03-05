package com.codingbox.web.servlet;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.BoardDAO;
import com.codingbox.web.dto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardWriteOKAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		// request 에서 넘어온 파라미터 값을 get해서 DTO에 넣어야함.
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = new BoardDTO();
		String boardtitle = request.getParameter("boardtitle");
		String username = request.getParameter("username");
		String boardcontents = request.getParameter("boardcontents");
		
		
		bdto.setBoardtitle(boardtitle);
		bdto.setUsername(username);
		bdto.setBoardcontents(boardcontents);
		
		
		
		
		if(bdao.insertBoard(bdto)) {
			forward.setPath("/board/BoardWrite.bo");
		}
		
		//dao insertBoard(dto) 파라미터3개있어서 dto에 담아서 넘길꺼임.
		//성공시 /board/BoardWrite.bo 에 forward 또는 redirect방식으로 넘김.
		forward.setRedirect(true);
		return forward;
	}

}
