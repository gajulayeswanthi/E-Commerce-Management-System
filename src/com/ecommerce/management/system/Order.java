package com.ecommerce.management.system;

public class Order {


	    private int userId;
	    private int productId;
	    private int quantity;
	    private double totalAmount;

	    public Order(int userId, int productId,
	                 int quantity, double totalAmount) {

	        this.userId = userId;
	        this.productId = productId;
	        this.quantity = quantity;
	        this.totalAmount = totalAmount;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public int getProductId() {
	        return productId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public double getTotalAmount() {
	        return totalAmount;
	    }
	
}
