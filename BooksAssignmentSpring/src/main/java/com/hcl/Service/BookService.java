package com.hcl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Books;
import com.hcl.Dao.BookDao;


@Service
public class BookService  implements IBookService{

	@Autowired
	BookDao dao;
	
	@Override
	public boolean userlogin(String email, String password) {
		// TODO Auto-generated method stub
		return dao.userlogin(email, password);
	}
	@Override
	public String Retrive_Name_of_loggedin(String email) {
		// TODO Auto-generated method stub
		return dao.Retrive_Name_of_loggedin(email);
	}
	@Override
	public int addUser(String uname, String email, String password) {
		// TODO Auto-generated method stub
		return dao.addUser(uname,email,password);
	}
	@Override
	public List<Books> RetriveBookDetails(Integer bookid) {
		// TODO Auto-generated method stub
		return dao.RetriveBookDetails(bookid);
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Books> DisplayBooks() {
		// TODO Auto-generated method stub
		return dao.DisplayBooks();
	}

	@Override
	public boolean ChecklikedBooks(Integer bookid) {
		// TODO Auto-generated method stub
		return dao.ChecklikedBooks(bookid);
	}

	@Override
	public String AddBookstoLikeSection(List<Books> bookDetails) {
		// TODO Auto-generated method stub
		return dao.AddBookstoLikeSection(bookDetails);
	}
	@Override
	public List<Books> DisplayLikedBooks() {
		// TODO Auto-generated method stub
		return dao.DisplayLikedBooks();
	}
	@Override
	public String RemovefromLikedSection(Integer bookId) {
		// TODO Auto-generated method stub
		return dao.RemovefromLikedSection(bookId);
	}
	@Override
	public boolean CheckReadLaterBooks(Integer bookid) {
		// TODO Auto-generated method stub
		return dao.CheckReadLaterBooks(bookid);
	}
	@Override
	public String AddBookstoReadLaterSection(List<Books> bookDetails) {
		// TODO Auto-generated method stub
		return dao.AddBookstoReadLaterSection(bookDetails);
	}
	@Override
	public List<Books> DisplayReadlaterBooks() {
		// TODO Auto-generated method stub
		return dao.DisplayReadlaterBooks();
	}
	@Override
	public String RemovefromReadLaterSection(Integer bookId) {
		// TODO Auto-generated method stub
		return dao.RemovefromReadLaterSection(bookId);
	}
	@Override
	public List<Books> SearchforBooks(String bookName) {
		// TODO Auto-generated method stub
		return dao.SearchforBooks(bookName);
	}


}
