package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.jmx.LoadBalanceConnectionGroupManager;
import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDao boardDao = new BoardDaoImpl();
	private static DBUtil util = DBUtil.getInstance();
	
	private BoardDaoImpl() {}

	public static BoardDao getBoardDao() {
		return boardDao;
	}


	@Override
	public void registerArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		TODO : boardDto의 내용을 board table에 insert 하세요!!!
		try {
			conn = util.getConnection();
			
			//pstmt 생성
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into board(subject, content, user_Id, register_time) \n");
			sql.append(" values(?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			pstmt.setString(i++, boardDto.getSubject());
			pstmt.setString(i++, boardDto.getContent());
			pstmt.setString(i++, boardDto.getUserId());
			pstmt.setString(i++, now.format(formatter));
			
			//실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}		
//		END
	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table의 모든 글정보를 글번호순으로 정렬하여 list에 담고 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select article_no, subject, content, user_Id, register_time \n");
			sql.append(" from board ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				int articleNo = rs.getInt(i++);
				String subject = rs.getString(i++);
				String content = rs.getString(i++);
				String userId = rs.getString(i++);
				String registerTime = rs.getString(i++);
				BoardDto bDto = new BoardDto(articleNo, subject, content, userId, registerTime);
				list.add(bDto);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}	
//		END
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table에서 제목에 subject를 포함하고 있는 글정보를 list에 담고 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select article_no, subject, content, user_Id, register_time \n");
			sql.append(" from board where subject like ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + subject + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				int articleNo = rs.getInt(i++);
				String rsSubject = rs.getString(i++);
				String content = rs.getString(i++);
				String userId = rs.getString(i++);
				String registerTime = rs.getString(i++);
				BoardDto bDto = new BoardDto(articleNo, rsSubject, content, userId, registerTime);
				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}	
//		END
		System.out.println(list.size());
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {
		BoardDto boardDto = null;
//		TODO : board table에서 글번호가 no인 글 한개를 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select article_no, subject, content, user_Id, register_time \n");
			sql.append(" from board where article_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
//			System.out.println(rs.first());
			while(rs.next()) {
				int i = 1;
				int articleNo = rs.getInt(i++);
				String rsSubject = rs.getString(i++);
				String content = rs.getString(i++);
				String userId = rs.getString(i++);
				String registerTime = rs.getString(i++);
				boardDto = new BoardDto(articleNo, rsSubject, content, userId, registerTime);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
//		END
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 이용하여 글번호에 해당하는 글제목과 내용을 수정하세요!!!
		try {
			conn = util.getConnection();
			
			//pstmt 생성
			StringBuilder sql = new StringBuilder();
			sql.append(" update board set subject = ?, content = ? where article_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			int i =1;
			pstmt.setString(i++, boardDto.getSubject());
			pstmt.setString(i++,  boardDto.getContent());
			pstmt.setInt(i++,  boardDto.getArticleNo());
			
			//실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}		
//		END
	}

	@Override
	public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : board table에서 글번호가 no인 글 정보를 삭제하세요!!!
		try {
			conn = util.getConnection();
			
			//pstmt 생성
			StringBuilder sql = new StringBuilder();
			sql.append(" delete from board where article_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			//실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}		
//		END
	}

}
