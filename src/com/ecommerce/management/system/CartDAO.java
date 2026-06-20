package com.ecommerce.management.system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CartDAO {
	public void addToCart(Cart cart) {

	        try {

	            Connection con = DBConnection.getConnection();

	            String query =
	                    "insert into cart(user_id,product_id,quantity) values(?,?,?)";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setInt(1, cart.getUserId());
	            ps.setInt(2, cart.getProductId());
	            ps.setInt(3, cart.getQuantity());

	            int rows = ps.executeUpdate();

	            if(rows > 0) {

	                System.out.println("Product Added To Cart");

	            }

	        } catch(Exception e) {

	            e.printStackTrace();
	        }
	    }
	
	public void viewCart(int userId) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	                "select * from cart where user_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, userId);

	        ResultSet rs =
	                ps.executeQuery();

	        System.out.println("Product ID\tQuantity");

	        while(rs.next()) {

	            System.out.println(
	                    rs.getInt("product_id") + "\t\t" +
	                    rs.getInt("quantity"));
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	
}
