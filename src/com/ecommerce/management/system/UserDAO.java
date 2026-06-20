package com.ecommerce.management.system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDAO {
		    public void registerUser(User user) {

	        try {

	            Connection con = DBConnection.getConnection();

	            String query =
	                    "insert into users(username,password,role) values(?,?,?)";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, user.getUsername());
	            ps.setString(2, user.getPassword());
	            ps.setString(3, user.getRole());

	            int rows = ps.executeUpdate();

	            if(rows > 0) {

	                System.out.println("Registration Successful");
	            }

	        } catch(Exception e) {

	            e.printStackTrace();
	        }
	    }
		    public boolean loginUser(String username, String password) {

		        try {

		            Connection con = DBConnection.getConnection();

		            String query =
		                    "select * from users where username=? and password=?";

		            PreparedStatement ps =
		                    con.prepareStatement(query);

		            ps.setString(1, username);
		            ps.setString(2, password);

		            ResultSet rs =
		                    ps.executeQuery();

		            if(rs.next()) {

		                return true;
		            }

		        } catch(Exception e) {

		            e.printStackTrace();
		        }

		        return false;
		    }
		    
		public int getUserId(String username) {

		        try {

		            Connection con = DBConnection.getConnection();

		            String query =
		                    "select user_id from users where username=?";

		            PreparedStatement ps =
		                    con.prepareStatement(query);

		            ps.setString(1, username);

		            ResultSet rs = ps.executeQuery();

		            if(rs.next()) {

		                return rs.getInt("user_id");
		            }

		        } catch(Exception e) {

		            e.printStackTrace();
		        }

		        return -1;
		    }
	}

