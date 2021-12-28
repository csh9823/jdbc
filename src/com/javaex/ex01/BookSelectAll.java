package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelectAll {

	public static void main(String[] args) {
		// 책+작가 데이터 가져오기
		List<BookVoall> booklist = new ArrayList<BookVoall>();
		
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
						
						BookVoall vo = new BookVoall(BookId,botitle,bopubs,bopubdate,auauthorid,auauthorname,authordesc);
						booklist.add(vo);
						
						/*
						 * 테이블 순서대로 출력 
						 * int authorId= rs.getInt(1); 
						 * String authorName =rs.getNString(2); 
						 * String authorDesc = rs.getString(3);
						 */
					}
					
					// 출력
					for(int i=0; i<booklist.size(); i++) {
						BookVoall bookvoall = booklist.get(i);
						System.out.println(bookvoall.getBookId() + "," + bookvoall.getBotitle() + "," + bookvoall.getBopubs()+","+ bookvoall.getBopubdate()+ ","+ bookvoall.getAuauthorid() + "," + bookvoall.getAuauthorname() + "," + bookvoall.getAuthordesc());
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

	}

}
