package Presentation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;


public class PresentationImpl implements Presentation {

	
	@Override
	public void showMenu() {
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		try {
			switch (choice) {
			case 1:
				
				break;

			case 2:
				
				break;

			case 3:
				
				break;

			case 4:
				
				break;
			}

		} catch (Exception exception) {

		}

	}

}
