package com.ecommerce.management.system;
import java.util.*;
public class AdminService {
	
	    Scanner sc = new Scanner(System.in);
	    ProductDAO dao = new ProductDAO();

	    public void adminMenu() {

	        while(true) {

	            System.out.println("\n===== ADMIN MENU =====");
	            System.out.println("1. Add Product");
	            System.out.println("2. View Products");
	            System.out.println("3. Update Product");
	            System.out.println("4. Delete Product");
	            System.out.println("5. Back");

	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            switch(choice) {

	                case 1:
	                    addProduct();
	                    break;

	                case 2:
	                    dao.viewProducts();
	                    break;

	                case 3:
	                    updateProduct();
	                    break;

	                case 4:
	                    deleteProduct();
	                    break;

	                case 5:
	                    return;

	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }

	    private void addProduct() {

	        System.out.print("Enter name: ");
	        String name = sc.next();

	        System.out.print("Enter price: ");
	        double price = sc.nextDouble();

	        System.out.print("Enter quantity: ");
	        int qty = sc.nextInt();

	        Product p = new Product(name, price, qty);
	        dao.addProduct(p);
	    }

	    private void updateProduct() {

	        System.out.print("Enter product id: ");
	        int id = sc.nextInt();

	        System.out.print("Enter new price: ");
	        double price = sc.nextDouble();
	        System.out.print("Enter New Stock: ");
	        int stock = sc.nextInt();

	        dao.updateProduct(id, price, stock);
	    }

	    private void deleteProduct() {

	        System.out.print("Enter product id: ");
	        int id = sc.nextInt();

	        dao.deleteProduct(id);
	    }
	}

