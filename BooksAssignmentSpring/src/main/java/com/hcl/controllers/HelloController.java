package com.hcl.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.Service.BookService;

import com.hcl.beans.Books;

@Controller
public class HelloController {

	@Autowired
	BookService service;

	@RequestMapping(value={"login", "AddToReadLater/login", "AddToLike/login"}, method = RequestMethod.POST)
	public ModelAndView Userlogin(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		if(service.userlogin(email ,password))
		{
			String username = service.Retrive_Name_of_loggedin(email);
		
		
			HttpSession sessionbook = request.getSession();

			sessionbook.setAttribute("name", username);
			ModelAndView mv1 = new ModelAndView();
			mv1.setViewName("Books");
			mv1.addObject("Books", service.DisplayBooks());
			String message="You are now logged in";
			mv1.addObject("alerttype", "success");
			mv1.addObject("message", message);
			mv=mv1;
			
			
		}
		else
		{
			
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("login");
			mv2.addObject("alerttype", "danger");
			
			String message="Username or password didn't match";
			mv2.addObject("message", message);
			mv=mv2;
		}
		return mv;
	
	}
	
	

	@RequestMapping(value={"/Register","AddToReadLater/Register","AddToLike/Register"})
	public String register() {
		return "Register";

	}
	
	
	@RequestMapping(value={"login","AddToReadLater/login","AddToLike/login"},method = RequestMethod.GET)
	public String login() {
		return "login";

	}
	

	@RequestMapping(value ="Registeruser",method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam("username") String uname, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		if (service.addUser(uname, email,password) != 0) {
         
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			mv.addObject("alerttype", "success");
			String message= uname+ " Successfully Registered please login";
			mv.addObject("message", message);
			return mv;
			
		} else {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("Register");
			mv.addObject("alerttype", "danger");
			String message= uname+ " Already Exist";
			mv.addObject("message", message);
			return mv;
		}
	}

	@RequestMapping(value={"logout", "AddToReadLater/logout", "AddToLike/logout"})
	public ModelAndView logout(HttpServletRequest request,RedirectAttributes redirectAttrs) {
	
		
		HttpSession existingsessionbook = request.getSession(false);
		System.out.println(existingsessionbook.getAttribute("name"));
		existingsessionbook.invalidate();
		
		redirectAttrs.addFlashAttribute("alerttype", "success");
		String message="logged out Successfully";
		redirectAttrs.addFlashAttribute("message", message);
		ModelAndView mv=new ModelAndView("redirect:/home");
	
		return mv;

	}
	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request,Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Books");
		mv.addObject("Books", service.DisplayBooks());
		mv.addObject("message",(String) model.asMap().get("message"));
		mv.addObject("alerttype", (String) model.asMap().get("alerttype"));
		return mv;
	}
	
	

	@RequestMapping("/AddToLike/{id}")
	public ModelAndView AddtoLike(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttrs) {

	
		
		 HttpSession Existingsession=request.getSession(false);  
        
      
			

			if (Existingsession == null || Existingsession.getAttribute("name")==null) {
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				mv.addObject("alerttype", "danger");
				String message= "Please login first";
				mv.addObject("message", message);
				return mv;
				
			}

			else {

				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);

				if (service.ChecklikedBooks(id)) {
				
					redirectAttrs.addFlashAttribute("alerttype", "warning");
					String message="You liked this book already";
					redirectAttrs.addFlashAttribute("message", message);
					ModelAndView mv=new ModelAndView("redirect:/home");
					return mv;

				}

				else {

					List<Books> BookDetails = service.RetriveBookDetails(id);
					String str = service.AddBookstoLikeSection(BookDetails);
					
					redirectAttrs.addFlashAttribute("alerttype", "success");
					String message=id+" added to like Section";
					redirectAttrs.addFlashAttribute("message", message);
					ModelAndView mv=new ModelAndView("redirect:/home");
					return mv;
				}
			}

		
		
	}
	
	
	@RequestMapping(value={"/DisplayBooksLiked","AddToReadLater/DisplayBooksLiked","AddToLike/DisplayBooksLiked"})
	public ModelAndView displayLiked(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		
		 HttpSession Existingsession=request.getSession(false);  
	        
	      
			

			if (Existingsession == null || Existingsession.getAttribute("name")==null) {
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				mv.addObject("alerttype", "danger");
				String message= "Please login first";
				mv.addObject("message", message);
				return mv;
				
			}
			else
			{
				
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("LikedBooks");
		mv.addObject("message",(String) model.asMap().get("message"));
		mv.addObject("alerttype", (String) model.asMap().get("alerttype"));
		mv.addObject("BooksLikedList", service.DisplayLikedBooks());
	
		return mv;
			}
	}
	
	@RequestMapping("/RemoveLikedBook/{id}")
	public ModelAndView removeLikedBook(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttrs) {

	
		
		
        
      

					
					String str = service.RemovefromLikedSection(id);
					
					redirectAttrs.addFlashAttribute("alerttype", "success");
				
					redirectAttrs.addFlashAttribute("message", str);
					ModelAndView mv=new ModelAndView("redirect:/DisplayBooksLiked");
					return mv;
				
			}

		
	

	@RequestMapping("/AddToReadLater/{id}")
	public ModelAndView AddtoReadLater(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttrs) {

	
		
		 HttpSession Existingsession=request.getSession(false);  
        
      
			

			if (Existingsession == null || Existingsession.getAttribute("name")==null) {
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				mv.addObject("alerttype", "danger");
				String message= "Please login first";
				mv.addObject("message", message);
				return mv;
				
			}

			else {

				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);

				if (service.CheckReadLaterBooks(id)) {
				
					redirectAttrs.addFlashAttribute("alerttype", "warning");
					String message="This book already in Read Later";
					redirectAttrs.addFlashAttribute("message", message);
					ModelAndView mv=new ModelAndView("redirect:/home");
					return mv;

				}

				else {

					List<Books> BookDetails = service.RetriveBookDetails(id);
					String str = service.AddBookstoReadLaterSection(BookDetails);
					
					redirectAttrs.addFlashAttribute("alerttype", "success");
					String message=id+" Added to Read later Section";
					redirectAttrs.addFlashAttribute("message", message);
					ModelAndView mv=new ModelAndView("redirect:/home");
					return mv;
				}
			}

		
		
	}
	
	@RequestMapping(value={"/DisplayReadLater","AddToReadLater/DisplayReadLater","AddToLike/DisplayReadLater"})
	public ModelAndView displayReadLater(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		
		 HttpSession Existingsession=request.getSession(false);  
	        
	      
			

			if (Existingsession == null || Existingsession.getAttribute("name")==null) {
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				mv.addObject("alerttype", "danger");
				String message= "Please login first";
				mv.addObject("message", message);
				return mv;
				
			}
			else
			{
				
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ReadLaterBooks");
		mv.addObject("message",(String) model.asMap().get("message"));
		mv.addObject("alerttype", (String) model.asMap().get("alerttype"));
		mv.addObject("BooksReadLaterList", service.DisplayReadlaterBooks());
	
		return mv;
			}
	}
	

	
	@RequestMapping("/RemoveReadLater/{id}")
	public ModelAndView removeReadLater(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttrs) {

	
		
		
        
      

					
					String str = service.RemovefromReadLaterSection(id);
					
					redirectAttrs.addFlashAttribute("alerttype", "success");
				
					redirectAttrs.addFlashAttribute("message", str);
					ModelAndView mv=new ModelAndView("redirect:/DisplayReadLater");
					return mv;
				
			}
	
	@RequestMapping(value="/searchBook",method = RequestMethod.POST)
	public ModelAndView searchBooks(@RequestParam("searchByname") String name ) {


					ModelAndView mv=new ModelAndView();
					mv.setViewName("SearchedBooks");
					mv.addObject("SearchBookList",service.SearchforBooks(name));
					return mv;
				
			}


}