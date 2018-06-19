package com.virtualpairprogrammers.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component				//This makes the class to be a spring bean - it can be injected to another class
@Scope("session")		//The shopping cart is session scope - just one shopping cart per session
public class ShoppingCart implements Serializable
{
	private List<Book> shopping = new ArrayList<Book>();

	public void addItem(Book newItem)
	{
		this.shopping.add(newItem);
	}
	
	public List<Book> getAllItems()
	{
		return shopping;
	}
	
	public void clear() 
	{
		this.shopping.clear();
	}
}
