package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.domain.Customer;

public interface AccountsService 
{
	public void raiseInvoice(Book requiredBook);
	
	public Customer findCustomer(String id) throws CustomerNotFoundException;
}
