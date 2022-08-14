package Presentation;

import java.util.HashSet;

import java.util.Optional;
import java.util.Scanner;

import Bean.Cart;
import Bean.Customer;
import Bean.Transaction;
import Persistence.TransactionDetailsDaoImpl;
import Service.allitemServiceImpl;
import Service.customerServiceImpl;
import Service.generate_billServiceImpl;
import Service.transactionDetailsServiceImpl;
import Service.transactionServiceImpl;


public class PresentationImpl implements Presentation {

	static int customer_id;
	@Override
	public void showMenu() {
		System.out.println("======Menu======");
		System.out.println("1. Show All Items");
		System.out.println("2. Go to Cart");
		System.out.println("3. Generate Bill");		
		System.out.println("4. Exit");
		

	}
	

	@Override
	public void performMenu(int choice) {
		
		customerServiceImpl cs=new customerServiceImpl();
		transactionDetailsServiceImpl tdsi=new transactionDetailsServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		try {
			switch (choice) {
			
			case 1:
				System.out.println("=============================================================");
				System.out.println("Showing All Items:");
				allitemServiceImpl item=new allitemServiceImpl();
				item.showallitem();
				System.out.println("=============================================================");
				break;
				
			case 2:
				
				while(true) {
				System.out.println("=============================================================");
				System.out.println("Showing All Items:");
				allitemServiceImpl item1=new allitemServiceImpl();
				item1.showallitem();
				System.out.println("=============================================================");
				
				System.out.println();
				System.out.println("1.Add to Cart");
				System.out.println("2.Delete from Cart");
				System.out.println("3.Update Item Quantity");
				System.out.println("4.Exit");
				
				System.out.println("Enter your choice:");
				int input = scanner.nextInt();
				
				switch(input) {
				case 1:
					System.out.println("Enter Item Id");
					int item_id=scanner.nextInt();
					System.out.println("Enter Quantity");
					int quan=scanner.nextInt();
					if(quan > 0) {
						
						if(tdsi.addToCart(new Cart(customer_id,item_id,item1.searchItem(item_id).getItem_Name(),quan,item1.searchItem(item_id).getItem_Price())))
							System.out.println("Added to cart");
						else
							System.out.println("Not available");
					}
					else {
						System.out.println("Enter Proper Quantity");
					}					
					break;
					
				case 2:
					System.out.println("Enter Item Id");
					int delete_item_id=scanner.nextInt();
					
					if (tdsi.deleteitemfromcart(delete_item_id)) {
						System.out.println("Item Deleted");
					}
					else {
						System.out.println("Not in the Cart");
					}
					
					break;
					
				case 3:
					System.out.println("Enter Item Id");
					int update_item_id=scanner.nextInt();
					System.out.println("Enter Quantity");
					int updated_quantity = scanner.nextInt();
					
					if(tdsi.updateitemquantity(update_item_id, updated_quantity)) {
						System.out.println("Item Quantity Updated");
					}
					else {
						System.out.println("Invalid Entry");
					}
					
					break;
					
				case 4:
				
					System.out.println("Exit from Cart.");	
					System.out.println();
					return;
				default:
					System.out.println("Invalid Coice");
					break;
					
					
				}
				
				
				}
				
				

			case 3:
				generate_billServiceImpl gb=new generate_billServiceImpl();
				//System.out.println("Enter Customer_id");
				//customer_id=scanner.nextInt();
				gb.generate_bill(customer_id);
				System.out.println("Bill:");
				
				transactionDetailsServiceImpl tddi=new transactionDetailsServiceImpl();
				transactionServiceImpl tdi=new transactionServiceImpl();
				Transaction t=tdi.searchTransaction(customer_id);
				tddi.deletetransactionDetail(t.getTransaction_ID());
				
				break;

			
			
			case 4:
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
		customer_id=scanner.nextInt();
		customerServiceImpl cs=new customerServiceImpl();
	
      
		if(cs.searchCustomer(customer_id)!=null) 
		{
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter password");
			String password=s1.nextLine();
			System.out.println(cs.searchCustomer(customer_id).getPassword());
			if(password.equals(cs.searchCustomer(customer_id).getPassword())) {
			System.out.println("loginSuccessful");
			while(true)
			{
		    showMenu();
		    int choice;
		    System.out.println("enter choice");
		    choice=scanner.nextInt();
		    performMenu(choice);
		    }
			}
			else
			{
				System.out.println("Password Incorrect");
			}
		}
		else
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Name");
		    String name=s.nextLine();
		    
		    System.out.println("Enter Username");
		    String username=s.nextLine();
		    
		    System.out.println("Enter Password");
		    String password=s.nextLine();
		    
		    Customer cust=new Customer(customer_id,name,username,password);
		    cs.addCustomer(cust);
		    System.out.println("Registration Successfull :)");
		    System.out.println("Login Now");
		    login();
		}
	}
}
