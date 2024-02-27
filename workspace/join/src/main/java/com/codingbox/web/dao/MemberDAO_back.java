//package com.codingbox.web.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.codingbox.web.dbconnection.DBConnection_back;
//import com.codingbox.web.dto.MemberDTO;
//
//import jakarta.servlet.http.HttpServlet;
//
//public class MemberDAO_back {
//
//	Connection conn;
//	PreparedStatement pstm;
//	ResultSet rs;
//	
//	// 회원가입
//	public boolean join(MemberDTO mDto) {
//		boolean result = false;
//		String sql = "INSERT INTO TBL_MEMBER VALUES (?,?,?,?,?)";
//		
//		try {
//			conn = DBConnection_back.getConnection();
//			pstm = conn.prepareStatement(sql);
//			pstm.setString(1,mDto.getUserid());
//			pstm.setString(2,mDto.getUserpw());
//			pstm.setString(3,mDto.getUsername());
//			pstm.setString(4,mDto.getUsergender());
//			pstm.setString(5,mDto.getUserphone());
//			if(pstm.executeUpdate()!=0) {
//				// 성공
//				result = true;
//			} else {
//				// 실패
//				result = false;
//			}
//				
//		}
//			catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("SQL 예외 발생");
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("알 수 없는 예외 발생");			
//			}
//			
//		return result;
//	}
//	
//	
//	// 로그인 확인
//	public MemberDTO login(String userid, String userpw) {
//		MemberDTO member = null;
//		
//		String sql 
//		= "SELECT * FROM tbl_member WHERE  USERID =? AND USERPW =?";
//			
//		
//		try {
//			conn = DBConnection_back.getConnection();
//			pstm = conn.prepareStatement(sql);
//			
//			//1번 물음표에 userid를 넘김
//			pstm.setString(1, userid);
//			//2번 물음표에 userpw를 넘김
//			pstm.setString(2, userpw);
//			
//			//실행
//			rs = pstm.executeQuery();
//			
//			if(rs.next()) {
////				rs.next()가 한건이라도 있으면
//				member = new MemberDTO();
//
//				// 이 부분을 내가 틀렸음
//				member.setUserid(rs.getString(1));
//				member.setUserpw(rs.getString(2));
//				member.setUsername(rs.getString(3));
//				member.setUsergender(rs.getString(4));
//				member.setUserphone(rs.getString(5));
//	
//				//여기를 수정해서, 사용자에 대한 모든 정보를 session 에 저장
//				//memberDTO 사용하면 됨
//				// 세션에다가 DTO 를 넣으면 되지않을까?
//				
//			}
//			
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("SQL 예외 발생");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("알 수 없는 예외 발생");			
//		}
//		
//		
//		return member;
//	}
//	
//	public boolean checkId(String userid) {
//		boolean result = false;
//		String sql 
//		= "SELECT COUNT(*) FROM tbl_member WHERE USERID =?";
//				
//			try {
//				// 디비 연결하고
//				conn = DBConnection_back.getConnection();
//				// 문장 날리고
//				pstm = conn.prepareStatement(sql);
//				
//				//1번 물음표에 userid를 넘김(내가 입력한 값)
//				pstm.setString(1, userid);
//				
//				//실행
//				rs = pstm.executeQuery();
//				
//				if(rs.next()) {
//					// count 값이 1일 경우 (getInt(1) 은 첫번째 열을 의미함)
//					if(rs.getInt(1) == 1) {
//						result = true;
//					}
//				}
//				else {
//					// 그렇지 않으면, 중복값이 없음
//					result = false;
//				}
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("SQL 예외 발생");
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("알 수 없는 예외 발생");			
//			}
//		
//		return result;
//	}
//	
//	
//}
