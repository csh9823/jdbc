package com.javaex.ex05;

import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<BookVo> List;
		BookDao bookDao = new BookDao();
		/*
		//작가 Dao

		AuthorDao authorDao = new AuthorDao();
		
		//작가 추가
		AuthorVo a01 = new AuthorVo("김문열", "경북 영양");
		authorDao.authorInsert(a01);

		AuthorVo a02 = new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(a02);

		AuthorVo a03 = new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(a03);

		AuthorVo a04 = new AuthorVo("기안84", "기안동에서 산 84년생");
		authorDao.authorInsert(a04);

		AuthorVo a05 = new AuthorVo("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert(a05);

		AuthorVo a06 = new AuthorVo("김영하", "알쓸신잡");
		authorDao.authorInsert(a06);

		AuthorVo a07 = new AuthorVo("이고잉", "개발자");
		authorDao.authorInsert(a07);
		
		//책 Dao
		
		//책 추가
		BookVo vo01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.BookInsert(vo01);

		BookVo vo02 = new BookVo("삼국지", "민음사", "2002-03-01", 1);
		bookDao.BookInsert(vo02);

		BookVo vo03 = new BookVo("토지", "마로니에 북스", "2012-08-15", 2);
		bookDao.BookInsert(vo03);

		BookVo vo04 = new BookVo("자바프로그래밍 입문", "위키북스", "2015-04-01", 7);
		bookDao.BookInsert(vo04);

		BookVo vo05 = new BookVo("패션왕", "중앙북스(books)", "2012-02-22", 4);
		bookDao.BookInsert(vo05);

		BookVo vo06 = new BookVo("순정만화", "재미주의", "2011-08-03", 5);
		bookDao.BookInsert(vo06);

		BookVo vo07 = new BookVo("오직두사람", "문학동네", "2017-05-04", 6);
		bookDao.BookInsert(vo07);

		BookVo vo08 = new BookVo("26년", "재미주의", "2012-02-04", 5);
		bookDao.BookInsert(vo08);
		*/
		//검색어 입력 Scanner
		System.out.println("검색어를 입력하세요");
		String ac;
		ac = sc.nextLine();
		//책에 검색 메소드
		
		
		//출력
		List = bookDao.Like(ac);
		for (int i = 0; i < List.size(); i++) {
			BookVo bookvoall = List.get(i);
			System.out.println(bookvoall.getBookId() + "," + bookvoall.getTitle() + "," + bookvoall.getPubs() + "," + bookvoall.getPubdate() + "," +bookvoall.getAuthorName());

		}
		
		
		
		/*
		BookDao bookDao = new BookDao();

		BookVo v01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.BookInsert(v01);

		BookVo v02 = new BookVo("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.BookInsert(v02);

		BookVo v03 = new BookVo("유시민의 글쓰기 특강", "생각의 길", "2015-04-01", 3);
		bookDao.BookInsert(v03);

		// 출력
		List = bookDao.bookSelect();

		for (int i = 0; i < List.size(); i++) {
			BookVo bookvoall = List.get(i);
			System.out.println(bookvoall.getBookId() + "," + bookvoall.getTitle() + "," + bookvoall.getPubs() + ","
					+ bookvoall.getPubdate() + "," + bookvoall.getAuthorId() + "," + bookvoall.getAuthorName() + ","
					+ bookvoall.getAuthorDesc());

		}

		System.out.println("----------------------------------------");

		// 수정
		BookVo update = new BookVo(1, "토지(수정)", "마로니에북스(수정)", "2012-08-15");

		bookDao.BookUpdate(update);

		// 출력
		List = bookDao.bookSelect();

		for (int i = 0; i < List.size(); i++) {
			BookVo bookvoall = List.get(i);
			System.out.println(bookvoall.getBookId() + "," + bookvoall.getTitle() + "," + bookvoall.getPubs() + ","
					+ bookvoall.getPubdate() + "," + bookvoall.getAuthorId() + "," + bookvoall.getAuthorName() + ","
					+ bookvoall.getAuthorDesc());

		}
		// 삭제
		bookDao.Bookdelete(2);

		// 출력
		List = bookDao.bookSelect();

		for (int i = 0; i < List.size(); i++) {
			BookVo bookvoall = List.get(i);
			System.out.println(bookvoall.getBookId() + "," + bookvoall.getTitle() + "," + bookvoall.getPubs() + ","
					+ bookvoall.getPubdate() + "," + bookvoall.getAuthorId() + "," + bookvoall.getAuthorName() + ","
					+ bookvoall.getAuthorDesc());

		}

*/
		sc.close();
	}

}
