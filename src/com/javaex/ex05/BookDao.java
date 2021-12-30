package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	// 필드

	// 생성자

	public BookDao() {

	}

	// 메소드gs

	// 메소드

	public void BookInsert(BookVo bookvo) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // ""webdb" 사용자 계정, "webdb" 비밀번호
			System.out.println("접속성공");
			// 3. SQL문 준비 / 바인딩 / 실행

			// 문자열 만들기
			String query = ""; // 쿼리문 만들기
			// query = query+"문자열"
			query = query + " insert into book";
			query = query + " values (seq_book_id.nextval, ?, ? ,? ,? )"; // values 앞에 한칸 띄어쓰기 해줘야됨

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩
			pstmt.setString(1, bookvo.getTitle()); // ?에 값 넣어줌
			pstmt.setString(2, bookvo.getPubs());
			pstmt.setString(3, bookvo.getPubdate());
			pstmt.setInt(4, bookvo.getAuthorId());

			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 결과처리
			System.out.println(count + "건이 저장되었습니다.");
			// 4.결과처리
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
	}

	public void Bookdelete(int a) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // "webdb" 사용자 계정, "webdb" 비밀번호
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 만들기
			// query = query+"문자열"
			query = query + " DELETE FROM book";
			query = query + " WHERE book_id = ? ";
			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			// 바인딩
			pstmt.setInt(1, a); // ?에 값 넣어줌
			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 결과처리
			System.out.println(count + "건이 삭제 되었습니다.");

			// 4.결과처리
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
	}

	public void BookUpdate(BookVo bookvo) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // "webdb" 사용자 계정, "webdb" 비밀번호
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 만들기
			// query = query+"문자열"
			query = query + " update  book";
			query = query + " set     title = ?,";
			query = query + "         pubs = ?, ";
			query = query + "         pub_date = ? ";
			query = query + " where   book_id = ? ";
			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			// 바인딩
			pstmt.setString(1, bookvo.getTitle()); // ?에 값 넣어줌
			pstmt.setString(2, bookvo.getPubs());
			pstmt.setString(3, bookvo.getPubdate());
			pstmt.setInt(4, bookvo.getBookId());
			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 결과처리
			System.out.println(count + "건이 업데이트 되었습니다.");

			// 4.결과처리
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
	}

	public List<BookVo> bookSelect() {
		List<BookVo> booklist = new ArrayList<BookVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행

			String query = "";
			query += " select  bo.book_id,";
			query += " bo.title,";
			query += " bo.pubs,";
			query += " to_char(bo.pub_date,'YYYY-MM-DD'),";
			query += " au.author_id,";
			query += " au.author_name,";
			query += " author_desc";
			query += " from    book bo, author au";
			query += " where   au.author_id = bo.author_id";

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩 --> 생략 ? 표 없음
			
			// 실행
			rs = pstmt.executeQuery(); // executeQuery() 사용 업데이트 x

			// 4.결과처리
			while (rs.next()) {
				int BookId = rs.getInt(1); // as로 이름 따로 주면 그 이름 사용 예 author_id id 일때 int authorId= rs.getInt("id");
				String botitle = rs.getNString(2);
				String bopubs = rs.getString(3);
				String bopubdate = rs.getString(4);
				int auauthorid = rs.getInt(5);
				String auauthorname = rs.getString(6);
				String authordesc = rs.getString(7);

				BookVo vo = new BookVo(BookId, botitle, bopubs, bopubdate, auauthorid, auauthorname, authordesc);
				booklist.add(vo);
				/*
				 * 테이블 순서대로 출력 int authorId= rs.getInt(1); String authorName =rs.getNString(2);
				 * String authorDesc = rs.getString(3);
				 */
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return booklist;
	}

	public List<BookVo> Like(String ac) {
		List<BookVo> booklist = new ArrayList<BookVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행

			String query = "";
			query += " select   bo.book_id,";
			query += " 			bo.title,";
			query += " 			bo.pubs,";
			query += " 			bo.pub_date,";
			query += " 			au.author_id,";
			query += " 			au.author_name,";
			query += " 			au.author_desc";
			query += " from     book bo, author au";
			query += " where  au.author_id = bo.author_id";
			query += " 		  and (bo.title, bo.pubs, au.author_name) IN ";
			query += " 			( select  bo.title,";
			query += " 			          bo.pubs,";
			query += " 			          au.author_name";
			query += " 			  from  book bo, author au";
			query += " 			  where  au.author_name like ?";
			query += " 					 or bo.title like ?";
			query += " 					 or bo.pubs like ?)";

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			
			// 바인딩 --> 생략 ? 표 없음
			pstmt.setString(1, '%' + ac + '%');
			pstmt.setString(2, '%' + ac + '%');
			pstmt.setString(3, '%' + ac + '%');
			// 실행
			rs = pstmt.executeQuery(); // executeQuery() 사용 업데이트 x

			// 4.결과처리
			while (rs.next()) {
				int BookId = rs.getInt(1); // as로 이름 따로 주면 그 이름 사용 예 author_id id 일때 int authorId= rs.getInt("id");
				String botitle = rs.getNString(2);
				String bopubs = rs.getString(3);
				String bopubdate = rs.getString(4);
				String auauthorname = rs.getString(5);

				BookVo vo = new BookVo(BookId, botitle, bopubs, bopubdate, auauthorname);
				booklist.add(vo);
				/*
				 * 테이블 순서대로 출력 int authorId= rs.getInt(1); String authorName =rs.getNString(2);
				 * String authorDesc = rs.getString(3);
				 */
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return booklist;
	}
}
