package com.ecommerce.management.system;

public class Cart {
	    private int userId;
	    private int productId;
	    private int quantity;

	    public Cart(int userId, int productId, int quantity) {

	        this.userId = userId;
	        this.productId = productId;
	        this.quantity = quantity;
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
	
}
