package com.javaex.ex01;

public class BookVoall {
	
	//필드
	private int BookId;
	private String botitle;
	private String bopubs;
	private String bopubdate;
	private int auauthorid;
	private String auauthorname;
	private String authordesc;
	//생성자
	public BookVoall(int bookId, String botitle, String bopubs, String bopubdate, int auauthorid, String auauthorname,
			String authordesc) {
		this.BookId = bookId;
		this.botitle = botitle;
		this.bopubs = bopubs;
		this.bopubdate = bopubdate;
		this.auauthorid = auauthorid;
		this.auauthorname = auauthorname;
		this.authordesc = authordesc;
	}
	
	public BookVoall() {
		
	}

	//메소드gs

	public int getBookId() {
		return BookId;
	}

	public String getBotitle() {
		return botitle;
	}

	public String getBopubs() {
		return bopubs;
	}

	public String getBopubdate() {
		return bopubdate;
	}

	public int getAuauthorid() {
		return auauthorid;
	}

	public String getAuauthorname() {
		return auauthorname;
	}

	public String getAuthordesc() {
		return authordesc;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public void setBotitle(String botitle) {
		this.botitle = botitle;
	}

	public void setBopubs(String bopubs) {
		this.bopubs = bopubs;
	}

	public void setBopubdate(String bopubdate) {
		this.bopubdate = bopubdate;
	}

	public void setAuauthorid(int auauthorid) {
		this.auauthorid = auauthorid;
	}

	public void setAuauthorname(String auauthorname) {
		this.auauthorname = auauthorname;
	}

	public void setAuthordesc(String authordesc) {
		this.authordesc = authordesc;
	}
	//메소드

	@Override
	public String toString() {
		return "BookVoall [BookId=" + BookId + ", botitle=" + botitle + ", bopubs=" + bopubs + ", bopubdate="
				+ bopubdate + ", auauthorid=" + auauthorid + ", auauthorname=" + auauthorname + ", authordesc="
				+ authordesc + "]";
	}
	
	
}
