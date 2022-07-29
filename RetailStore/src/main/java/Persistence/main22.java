package Persistence;

import Bean.Customer;

public class main22 {
	public static void main(String args[])
	{
		TransactionDetailsDaoImpl t=new TransactionDetailsDaoImpl();
		t.showalltransactionDetails();
		
		CustomerDaoImp c=new CustomerDaoImp();
		c.showCustomer();
		
		Customer cust=new Customer(5,"Teja", "teja@gmail.com","11111");
		boolean row=c.addCustomer(cust);
		
		System.out.println("added "+row+" row");
		
       c.showCustomer();

		System.out.println(c.searchCustomer(1));
		
		transactionDaoImpl t1=new transactionDaoImpl();
		t1.showalltransactions();
		System.out.println("done");
		System.out.println("kkkkk");
	}

}
