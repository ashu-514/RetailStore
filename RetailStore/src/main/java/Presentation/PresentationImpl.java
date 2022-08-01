package Presentation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;


public class PresentationImpl implements Presentation {

	
	@Override
	public void showMenu() {
		System.out.println("1. Login");
		System.out.println("2. Add To Cart");
		System.out.println("3. Generate Bill");
		System.out.println("4. Show All Items");
		System.out.println("5. Show All Transactions");
		System.out.println("6. Show All Transactions Details");
		System.out.println("7. Show All Customers");
		System.out.println("8. Exit");
		

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		try {
			switch (choice) {
			case 1:
				System.out.println("Enter Username");
				System.out.println("Enter Password");
				
				break;

			case 2:
				System.out.println("Add New Item");
				System.out.println("Remove Item");
				
				break;

			case 3:
				System.out.println("Bill:");
				
				break;

			case 4:
				System.out.println("Items:");
				break;
			
			case 5:
				System.out.println("Transactions:");
				break;
				
			case 6:
				System.out.println("Transaction Details:");
				break;
			case 7:
				break;
			case 8:
				System.out.println("Thanks for Visiting Our Store.");
				System.exit(0);
			default:
				System.out.println("Invalid Coice");
				break;
				
				
			}
			

		} catch (Exception exception) {

		}

	}

}
