package com.ecommerce.management.system;
import java.util.*;
public class CustomerService {


	    Scanner sc = new Scanner(System.in);
	    UserDAO dao = new UserDAO();
	    private int loggedInUserId;
	    public void customerMenu() {

	        while(true) {

	            System.out.println("\n===== CUSTOMER MENU =====");
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. Back");

	            System.out.print("Enter Choice: ");
	            int choice = sc.nextInt();

	            switch(choice) {

	                case 1:
	                    register();
	                    break;

	                case 2:
	                    login();
	                    break;
                   
	                

	                case 3:
	                    return;

	                default:
	                    System.out.println("Invalid Choice");
	            }
	        }
	    }

	    private void register() {

	        System.out.print("Enter Username: ");
	        String username = sc.next();

	        System.out.print("Enter Password: ");
	        String password = sc.next();

	        User user = new User(username, password, "CUSTOMER");

	        dao.registerUser(user);
	    }

	    private void login() {

	        System.out.print("Enter Username: ");
	        String username = sc.next();

	        System.out.print("Enter Password: ");
	        String password = sc.next();

	        boolean status = dao.loginUser(username, password);

	        if(status) {

	        	loggedInUserId = dao.getUserId(username);

	            System.out.println("Login Successful");
	            customerDashboard();
	        

	        } else {

	            System.out.println("Invalid Username or Password");
	        }
	    }
	    
	    private void addToCart() {

	        System.out.print("Enter Product ID: ");
	        int productId = sc.nextInt();

	        System.out.print("Enter Quantity: ");
	        int quantity = sc.nextInt();

	        Cart cart =
	                new Cart(loggedInUserId,
	                         productId,
	                         quantity);

	        CartDAO dao = new CartDAO();

	        dao.addToCart(cart);
	    }
	    
	private void customerDashboard() {

	        while(true) {

	            System.out.println("\n===== CUSTOMER DASHBOARD =====");
	            System.out.println("1. View Products");
	            System.out.println("2. Add To Cart");
	            System.out.println("3. View Cart");
	            System.out.println("4. Place Order");
	            System.out.println("5. Logout");

	            System.out.print("Enter Choice: ");
	            int choice = sc.nextInt();

	            switch(choice) {

	                case 1:

	                    ProductDAO dao = new ProductDAO();
	                    dao.viewProducts();
	                    break;
	                case 2:

	                    addToCart();
	                    break;
                     
	                case 3:

	                    CartDAO d = new CartDAO();
	                    d.viewCart(loggedInUserId);
	                    break;
	                    
	                case 4:
	                    placeOrder();
	                    break;


	                case 5:

	                    return;

	                default:

	                    System.out.println("Invalid Choice");
	            }
	        }
	    }
	private void placeOrder() {

	    System.out.print("Enter Product ID: ");
	    int productId = sc.nextInt();

	    System.out.print("Enter Quantity: ");
	    int quantity = sc.nextInt();

	    System.out.print("Enter Total Amount: ");
	    double totalAmount = sc.nextDouble();

	    Order order =
	            new Order(loggedInUserId,
	                      productId,
	                      quantity,
	                      totalAmount);

	    OrderDAO dao = new OrderDAO();

	    dao.placeOrder(order);
	}
	}

