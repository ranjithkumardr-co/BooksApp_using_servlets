package com.hcl.Service;

import java.util.List;

import com.hcl.beans.Books;

public interface IBookService {

	
	public boolean userlogin(String email, String password);
	public String Retrive_Name_of_loggedin(String email);
	public int addUser(String uname, String email, String password);
	
	
	
	
	
	
	
	public List<Books> DisplayBooks();

	public boolean ChecklikedBooks(Integer bookid);
	public List<Books> RetriveBookDetails(Integer bookid);
	public String AddBookstoLikeSection(List<Books> bookDetails);
	public List<Books> DisplayLikedBooks();
	public String RemovefromLikedSection(Integer bookId);
	public boolean CheckReadLaterBooks(Integer bookid);
	public String AddBookstoReadLaterSection(List<Books> bookDetails);
	public List<Books> DisplayReadlaterBooks();
	public String RemovefromReadLaterSection(Integer bookId);
	public List<Books> SearchforBooks(String bookName);
}
