package com.ecommerce.management.system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
	    public void addProduct(Product product) {

	        try {

	            Connection con = DBConnection.getConnection();

	            String query =
	                    "INSERT INTO products(product_name,price,stock) VALUES(?,?,?)";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, product.getProductName());
	            ps.setDouble(2, product.getPrice());
	            ps.setInt(3, product.getStock());

	            int rows = ps.executeUpdate();

	            if(rows > 0) {
	                System.out.println("Product Added Successfully");
	            }

	        } catch(Exception e) {

	            e.printStackTrace();
	        }
	    }
public void viewProducts() {

	        try {

	            Connection con = DBConnection.getConnection();

	            String query = "SELECT * FROM products";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ResultSet rs =
	                    ps.executeQuery();

	            while(rs.next()) {

	                System.out.println(
	                        rs.getInt("product_id") + " " +
	                        rs.getString("product_name") + " " +
	                        rs.getDouble("price") + " " +
	                        rs.getInt("stock"));
	            }

	        } catch(Exception e) {

	            e.printStackTrace();
	        }
	    }

public void updateProduct(int id, double price, int stock) {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "update products set price=?, stock=? where product_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setDouble(1, price);
        ps.setInt(2, stock);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {

            System.out.println("Product Updated Successfully");

        } else {

            System.out.println("Product Not Found");
        }

    } catch(Exception e) {

        e.printStackTrace();
    }
}

public void deleteProduct(int id) {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "delete from products where product_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {

            System.out.println("Product Deleted Successfully");

        } else {

            System.out.println("Product Not Found");
        }

    } catch(Exception e) {

        e.printStackTrace();
    }
}
	
}
