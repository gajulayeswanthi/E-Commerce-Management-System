package com.ecommerce.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class OrderDAO {
	public void placeOrder(Order order) {

	        try {

	            Connection con = DBConnection.getConnection();

	            String query =
	                    "insert into orders(user_id,product_id,quantity,total_amount) values(?,?,?,?)";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setInt(1, order.getUserId());
	            ps.setInt(2, order.getProductId());
	            ps.setInt(3, order.getQuantity());
	            ps.setDouble(4, order.getTotalAmount());

	            int rows = ps.executeUpdate();

	            if(rows > 0) {

	                System.out.println("Order Placed Successfully");
	            }

	        } catch(Exception e) {

	            e.printStackTrace();
	        }
	    }
	}

