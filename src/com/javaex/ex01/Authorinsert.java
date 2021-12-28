package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Authorinsert {

	public static void main(String[] args) {
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
			
			//문자열 만들기
			String query = ""; //쿼리문 만들기
			//query = query+"문자열"
			query = query + "insert into author";
			query = query + " values (seq_author_id.nextval, ?, ?)"; // values 앞에 한칸 띄어쓰기 해줘야됨
			
			//문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			
			//바인딩
			pstmt.setString(1, "이문열"); // ?에 값 넣어줌
			pstmt.setString(2, "경북 영양");
			
			//실행
			int count = pstmt.executeUpdate(); //쿼리문 실행
			
			//결과처리
			System.out.println(count +"건이 저장되었습니다.");
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
