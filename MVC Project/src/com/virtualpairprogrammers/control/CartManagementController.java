package com.virtualpairprogrammers.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.domain.ShoppingCart;
import com.virtualpairprogrammers.services.BookService;

@Controller					//Approach 1 - The old way to handle sessions with no scope
//@Scope("session")			//Approach 2 - The controller is session scope - just one controller per session
@Scope("request")			//Apporach 3 - The controller is request scope - just one controller per user request
public class CartManagementController
{
	@Autowired
	private BookService bookService;

//	//Apporach 2
//	private ShoppingCart cart = new ShoppingCart();
	
	//Apporach 3
	@Autowired
	private ShoppingCart cart;

	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam("id") int id, HttpSession session)
	{
		Book requiredBook = bookService.getBookById(id);

		// BUT HOW DO WE ADD IT TO THE USER'S SESSION?
		
//		//Approach 1 - Use the Session Directly
//		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
//		if (cart == null)
//		{
//			cart = new ShoppingCart();
//		}
//		cart.addItem(requiredBook);
//		session.setAttribute("cart", cart);
		
		//Approach 2 and 3 - Scope the session
		this.cart.addItem(requiredBook);

		return new ModelAndView("bookAddedToCart", "title", requiredBook.getTitle());
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart(HttpSession session)
	{
		//Approach 1 - Use the Session Directly
//		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
//		if (cart == null)
//		{
//			cart = new ShoppingCart();
//		}
//		return new ModelAndView("/cartContents.jsp", "cart", cart.getAllItems());
		
		//Approach 2 and 3 - Scope the session
		return new ModelAndView("cartContents", "cart", this.cart.getAllItems());
	}

}
