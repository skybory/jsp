package com.codingbox.web.servlet;

import java.util.ArrayList;

import com.codingbox.web.action.Action;
import com.codingbox.web.action.ActionForward;
import com.codingbox.web.dao.BoardDAO;
import com.codingbox.web.dto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		BoardDAO bdao = new BoardDAO();
		int totalCnt = bdao.getBoardCnt();
	
		// 현재 페이지 넘겨받기
		String temp = request.getParameter("page");
		int page = 0;
		
		page = temp == null ? 1 : Integer.parseInt(temp);
		
//		if(temp==null) {
//			page = 1;
//		}	else {
//			page = Integer.parseInt(temp);
//		}

		int pageSize = 10;
		int endRow = page * pageSize;
		int startRow = endRow - pageSize +1;
		
		// [1],[2]...[10] : 1페이지, [11],[12]...[20] : 11페이지
		int startPage = (page-1)/pageSize * pageSize+1;
		
		// [1],[2]...[10] : 10페이지, [11],[12]...[20] : 20페이지
		int endPage = startPage + pageSize-1;
		
		int totalPage = (totalCnt-1)/pageSize + 1;
		
		endPage = endPage> totalPage ? totalPage : endPage;
		
		
		
		request.setAttribute("boardList", bdao.getBoardList(startRow, endRow));
		
		// 게시판 전체 글의 갯수를 카운트
		request.setAttribute("totalCnt", totalCnt);
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		//forward 방식으로 페이지 이동
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/board/boardlist.jsp");
// request.getContextPath() 이 부분은 경로가 깨질 경우 사용
		
		if(bdao.getBoardList(startRow, endRow) != null) {
			
			forward.setPath("/board/boardlist.jsp");
			bdao.getBoardList(startRow, endRow);
//			forward.setRedirect(false);
		}
		
		// DAO 객체 생성, getBoardList(), DB select
		// forward 방식으로 페이지 이동 -> board/boardlist.jsp 로 이동
		
		return forward;
	}

}
