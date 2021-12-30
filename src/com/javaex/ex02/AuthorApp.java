package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		
		List<AuthorVo> List;
		//작가 등록
		authorDao.authorInsert("이문열", "경북 영양");
		
		//작가 등록
		authorDao.authorInsert("박경리", "경상남도 통영");
		
		
		//작가 등록
		authorDao.authorInsert("유시민", "17대 국회의원");
		
		//테이블 출력
		
		List = authorDao.authorSelect();
		
		for(int i=0; i<List.size(); i++) {
			AuthorVo vo = List.get(i);
			System.out.println(vo.getAuthorId()+","+vo.getAuthorName()+","+ vo.getAuthorDesc());
		}
		System.out.println("--------------------------------------------------------------------------");
		//작가 수정
		authorDao.authorUpdate(1, "김문열" , "경상북도 영양");
		
		//테이블 출력
		
				List = authorDao.authorSelect();
				
				for(int i=0; i<List.size(); i++) {
					AuthorVo vo = List.get(i);
					System.out.println(vo.getAuthorId()+","+vo.getAuthorName()+","+ vo.getAuthorDesc());
				}
				System.out.println("--------------------------------------------------------------------------");
		//작가삭제
		authorDao.authorDelete(1);
		
		//테이블 출력
		
		List = authorDao.authorSelect();
		
		for(int i=0; i<List.size(); i++) {
			AuthorVo vo = List.get(i);
			System.out.println(vo.getAuthorId()+","+vo.getAuthorName()+","+ vo.getAuthorDesc());
		}
	}

}
