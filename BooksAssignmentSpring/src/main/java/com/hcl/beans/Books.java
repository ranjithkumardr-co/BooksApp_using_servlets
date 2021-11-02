package com.hcl.beans;

public class Books {
	private int bookid;
	private String bookname;
	private String bookurl;
	private String category;
	private String authorname;
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", bookurl=" + bookurl + ", category=" + category
				+ ", authorname=" + authorname + "]";
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookurl() {
		return bookurl;
	}
	public void setBookurl(String bookurl) {
		this.bookurl = bookurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

}
