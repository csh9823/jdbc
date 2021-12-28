package com.javaex.ex01;

public class BookVO {
	
	//필드
	private int BookId ;
	private String title;
	private String pubs;
	private String authorid;
	
	//생성자
	public BookVO(int bookId, String title, String pubs, String authorid) {
		BookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.authorid = authorid;
	}
	
	public BookVO() {
		
	}

	//메소드 gs
	
	public int getBookId() {
		return BookId;
	}

	public String getTitle() {
		return title;
	}

	public String getPubs() {
		return pubs;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	
	//메소드
	@Override
	public String toString() {
		return "BookVO [BookId=" + BookId + ", title=" + title + ", pubs=" + pubs + ", authorid=" + authorid + "]";
	}
}
