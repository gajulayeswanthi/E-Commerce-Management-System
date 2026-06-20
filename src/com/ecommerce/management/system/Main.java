package com.ecommerce.management.system;
import java.util.*;
public class Main {
	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);

	    AdminService admin = new AdminService();
	    CustomerService customer = new CustomerService();

	    while(true) {

	        System.out.println("\n===== E-COMMERCE SYSTEM =====");
	        System.out.println("1. Admin");
	        System.out.println("2. Customer");
	        System.out.println("3. Exit");

	        System.out.print("Enter Choice : ");

	        int choice = sc.nextInt();

	        switch(choice) {

	        case 1:
	            admin.adminMenu();
	            break;

	        case 2:
	            customer.customerMenu();
	            break;

	        case 3:
	            System.out.println("Thank You");
	            System.exit(0);

	        default:
	            System.out.println("Invalid Choice");
	        }
	    }
	}
     
}

