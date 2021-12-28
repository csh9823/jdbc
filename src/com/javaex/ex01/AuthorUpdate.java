package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorUpdate {

	public static void main(String[] args) {
		
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
			String query = ""; //쿼리문 만들기
			//query = query+"문자열"
			query = query + " update  author";
			query = query + " set     author_desc = ?,";
			query = query + " author_name = ? ";
			query = query + " where   author_id = ? ";
			//문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			//바인딩
			pstmt.setString(1, "삼국지 작가"); // ?에 값 넣어줌
			pstmt.setString(2, "이문열");
			pstmt.setInt(3, 1);
			
			//실행
			int count = pstmt.executeUpdate(); //쿼리문 실행
			
			//결과처리
			System.out.println(count +"건이 업데이트 되었습니다.");
			
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
}
