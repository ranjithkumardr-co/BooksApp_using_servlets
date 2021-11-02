package com.hcl.Dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Books;
import com.hcl.beans.Users;

@Repository
public class BookDao {

	@Autowired
	private JdbcTemplate template;


	

	public boolean userlogin(String email, String password) {
		// TODO Auto-generated method stub
		boolean test = false;

		String sql = "SELECT * FROM users where Email=? and password=?";

		List<Users> users = template.query(sql, new UserRowMapper(), email, password);

		for (Users u : users) {
			String uemail = u.getEmail();
			String upassword = u.getPassword();
			if ((uemail.equals(email)) && (upassword.equals(password))) {

				test = true;
			}

			else {

				test = false;
			}

		}

		return test;

	}

	public String Retrive_Name_of_loggedin(String email) {
		// TODO Auto-generated method stub
		String UserName = "";
	

			String sql = "SELECT * FROM users where email=? ";

			List<Users> users = template.query(sql, new UserRowMapper(), email);
			if(users.size()>0)
			{
				for (Users u : users) {
					UserName=u.getUsername();
				}
			}

		

			else {
				UserName = "Anonymous";
			}
		
          System.out.println(UserName);
	
		return UserName;
	}

	public int addUser(String uname, String email, String password) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users VALUES (?,?,?,?)";

		if (template.update(sql, null, uname, email, password) != 0) {
			return 1;

		} else {
			return 0;
		}

	}

	public List<Books> RetriveBookDetails(Integer bookid) {
		// TODO Auto-generated method stub
		List<Books> likelist = new ArrayList<Books>();

		String sql = "SELECT * FROM Books where Bookid=?";

		likelist.clear();
		likelist = template.query(sql, new BooksRowMaper(), bookid);

		return likelist;
	}
	
	public String AddBookstoLikeSection(List<Books> bookDetails) {
		// TODO Auto-generated method stub
		String test = "";
		Integer results=0;
			String sql = "INSERT INTO Likedbooks VALUES (?,?,?,?,?)";

			
			for (Books c : bookDetails) {

				 results=template.update(sql,c.getBookid(),c.getBookurl(),c.getBookname(),c.getCategory(),c.getAuthorname());
		
			}

			

			if (results != 0) {
				test = "Book added successfully";
			} else {

				test = "Book not added";
			}
			
		
		return test;
	}

	
	public boolean ChecklikedBooks(Integer bookid) {
		// TODO Auto-generated method stub
		boolean test = false;
	

			String sql = "SELECT * from  Likedbooks where Bookid=?";
		
            List<Books> list=template.query(sql, new BooksLikedRow(),bookid);
            for(Books b:list)
            {
            	Integer id=b.getBookid();
            	if (id == bookid) {
					test = true;
				} else {
					test = false;
				}
            }
			
			
					
				

			

	
		return test;
	}

	public List<Books> DisplayBooks() {
		// TODO Auto-generated method stub
	

			String sql = "SELECT * FROM Books";
			List<Books> list = new ArrayList<Books>();

			list.clear();
			list=template.query(sql,new BooksRowMaper());
		
		return list;

	}

	


	public List<Books> DisplayLikedBooks() {
		// TODO Auto-generated method stub
		List<Books> Bookslikedlist = new ArrayList<Books>();
	

			String sql = "SELECT * FROM LikedBooks";
		

			Bookslikedlist.clear();

			Bookslikedlist=template.query(sql,new BooksLikedRow());
		

			

	
		return Bookslikedlist;
	}

	
	public String RemovefromLikedSection(Integer bookId) {
		// TODO Auto-generated method stub
		String test = "";
		
			String sql = "DELETE from Likedbooks where Bookid=?";

			
       Integer results=template.update(sql,bookId);
			

			if (results != 0) {
				test = "Book " + bookId + " Removed successfully";
			} else {

				test = "Book " + bookId + "  Not Removed";
			}
			
	
		return test;
	}



	public String AddBookstoReadLaterSection(List<Books> bookDetails) {
		// TODO Auto-generated method stub
		String test = "";
		Integer results=0;
			String sql = "INSERT INTO ReadLater VALUES (?,?,?,?,?)";

			
			for (Books c : bookDetails) {

				 results=template.update(sql,c.getBookid(),c.getBookurl(),c.getBookname(),c.getCategory(),c.getAuthorname());
		
			}

			

			if (results != 0) {
				test = "Book added successfully";
			} else {

				test = "Book not added";
			}
			
		
		return test;
	}

	public boolean CheckReadLaterBooks(Integer bookid) {
		// TODO Auto-generated method stub
		boolean test = false;
	

			String sql = "SELECT * from  ReadLater where Bookid=?";
		
            List<Books> list=template.query(sql, new BooksLikedRow(),bookid);
            for(Books b:list)
            {
            	Integer id=b.getBookid();
            	if (id == bookid) {
					test = true;
				} else {
					test = false;
				}
            }
			
			
					
				

			

	
		return test;
	}
	public List<Books> DisplayReadlaterBooks() {
		// TODO Auto-generated method stub
		List<Books> Bookslikedlist = new ArrayList<Books>();
		

		String sql = "SELECT * FROM Readlater";
	

		Bookslikedlist.clear();

		Bookslikedlist=template.query(sql,new BooksLikedRow());
	

		


	return Bookslikedlist;
	}

	public String RemovefromReadLaterSection(Integer bookId) {
		// TODO Auto-generated method stub
		String test = "";
		
		String sql = "DELETE from Readlater where Bookid=?";

		
   Integer results=template.update(sql,bookId);
		

		if (results != 0) {
			test = "Book " + bookId + " Removed successfully";
		} else {

			test = "Book " + bookId + "  Not Removed";
		}
		

	return test;
	}

	public List<Books> SearchforBooks(String bookName) {
		// TODO Auto-generated method stub
		List<Books> BooksSearchlist = new ArrayList<Books>();
		List<Books> BooksSearchlist1 = new ArrayList<Books>();
		

			String sql = "SELECT * FROM Books where BookName REGEXP ?";
			

			BooksSearchlist.clear();
			BooksSearchlist=template.query(sql, new BooksRowMaper(),bookName);
			
			if (BooksSearchlist.isEmpty()) {
	
				BooksSearchlist1 = null;
				
				

			} else {
				BooksSearchlist1 = BooksSearchlist;
				
			}

	
		return BooksSearchlist1;
	}

}
