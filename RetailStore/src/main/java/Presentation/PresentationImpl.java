package Presentation;

import java.util.HashSet;

import java.util.Optional;
import java.util.Scanner;

import Bean.Customer;
import Service.customerServiceImpl;


public class PresentationImpl implements Presentation {

	
	@Override
	public void showMenu() {
		System.out.println("1. Add To Cart");
		System.out.println("2. Generate Bill");
		System.out.println("3. Show All Items");
		System.out.println("4. Show All Transactions");
		System.out.println("5. Show All Transactions Details");
		System.out.println("6. Show All Customers");
		System.out.println("7. Exit");
		

	}
	

	@Override
	public void performMenu(int choice) {
		
		customerServiceImpl cs=new customerServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		try {
			switch (choice) {
			case 1:
				System.out.println("Add New Item");
				System.out.println("Remove Item");
				
				break;

			case 2:
				System.out.println("Bill:");
				
				break;

			case 3:
				System.out.println("Items:");
				break;
			
			case 4:
				System.out.println("Transactions:");
				break;
				
			case 5:
				System.out.println("Transaction Details:");
				break;
			case 6:
				break;
			case 7:
				System.out.println("Thanks for Visiting Our Store.");
				System.exit(0);
			default:
				System.out.println("Invalid Coice");
				break;
				
				
			}
			

			
		} catch (Exception exception) {

		}

	}
     @Override
	public void login()
	{
		System.out.println("Login");
		System.out.println("Enter customer_id");
		Scanner scanner = new Scanner(System.in);
		int cid=scanner.nextInt();
		customerServiceImpl cs=new customerServiceImpl();

		if(cs.searchCustomer(cid)) {
			System.out.println("loginSuccessful");
			while(true) {
		    showMenu();
		    int choice;
		    System.out.println("enter choice");
		    choice=scanner.nextInt();
		    performMenu(choice);}}
		else
		{
			System.out.println("Enter Name");
		    String name=scanner.nextLine();
		    System.out.println("Enter Username");
		    String username=scanner.nextLine();
		    System.out.println("Enter Password");
		    String password=scanner.nextLine();
		    Customer cust=new Customer(cid,name,username,password);
		    cs.addCustomer(cust);
		    System.out.println("Welcome To RetailStore XYZ :)");
		}
	}
}
