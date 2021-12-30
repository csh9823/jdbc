
//Dao만들기 , AuthorVo사용, 공통변수 빼기
package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	// 필드

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 생성자
	public AuthorDao() {

	}

	// 메소드gs

	// 메소드 일반
	//private 사용이유 메인에서 사용 못 하게 할려고
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩'
			Class.forName(driver);
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	private void close() {
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

	public void authorInsert(AuthorVo authorVo) {

		// 로딩 connection얻어오기
		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행

			// 문자열 만들기
			String query = ""; // 쿼리문 만들기
			// query = query+"문자열"
			query = query + " insert into author";
			query = query + " values (seq_author_id.nextval, ?, ?)"; // values 앞에 한칸 띄어쓰기 해줘야됨

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩
			pstmt.setString(1, authorVo.getAuthorName()); // ?에 값 넣어줌
			pstmt.setString(2, authorVo.getAuthorDesc());

			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 결과처리
			System.out.println(count + "건이 저장되었습니다.");

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();

	}

	public void authorDelete(int b) {

		// 로딩 connection얻어오기
		getConnection();
		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 만들기
			// query = query+"문자열"
			query = query + " DELETE FROM author";
			query = query + " WHERE author_id = ? ";
			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			// 바인딩
			pstmt.setInt(1, b); // ?에 값 넣어줌
			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 결과처리
			System.out.println(count + "건이 삭제 되었습니다.");

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
	}

	public void authorUpdate(AuthorVo authorVo) {
		
		// 로딩 connection얻어오기
				getConnection();
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 만들기
			// query = query+"문자열"
			query = query + " update  author";
			query = query + " set     author_desc = ?,";
			query = query + " author_name = ?"; // author_name = ?
			query = query + " where   author_id = ? ";
			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
			// 바인딩
			pstmt.setString(1, authorVo.getAuthorDesc()); // ?에 값 넣어줌
			pstmt.setString(2, authorVo.getAuthorName());
			pstmt.setInt(3, authorVo.getAuthorId());

			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 결과처리
			System.out.println(count + "건이 업데이트 되었습니다.");

			// 4.결과처리
		}catch (SQLException e) {
				System.out.println("error:" + e);
			}
		close();
		}
	

	public List<AuthorVo> authorSelect() {

		List<AuthorVo> authorList = new ArrayList<AuthorVo>();

		// 로딩 connection얻어오기
		getConnection();
		try {
			// 3. SQL문 준비 / 바인딩 / 실행

			String query = "";
			query += " select  author_id id,";
			query += "         author_name,";
			query += "         author_desc";
			query += " from author";

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩 --> 생략 ? 표 없음

			// 실행
			rs = pstmt.executeQuery(); // executeQuery() 사용 업데이트 x

			// 4.결과처리

			while (rs.next()) {
				int authorId = rs.getInt(1); // as로 이름 따로 주면 그 이름 사용 예 author_id id 일때 int authorId= rs.getInt("id");
				String authorName = rs.getNString(2);
				String authorDesc = rs.getString(3);

				AuthorVo vo = new AuthorVo(authorId, authorName, authorDesc);
				authorList.add(vo);

				/*
				 * 테이블 순서대로 출력 int authorId= rs.getInt("1"); String authorName =
				 * rs.getNString("2"); String authorDesc = rs.getString("3");
				 */

				/* System.out.println(authorId+ "," + authorName +"," + authorDesc); */
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return authorList;
	}
}
