package com.bbs.demorest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Repository {
	
	Connection con = null;
	
	public Repository() {
		System.out.println("Repository");
		String url = "jdbc:mysql://localhost:3306/restdb?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = ENV.username;
		String password = ENV.password;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public List<Customer> getCustomers(){
		List<Customer> customers = new ArrayList<>();
		String sql = "select * from customer";
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setEmail(rs.getString(3));
				
				customers.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public Customer getCustomer(int id){
		String sql = "select * from customer where id="+id;
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				Customer cust = new Customer();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setEmail(rs.getString(3));
				
				return cust;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void createCustomer(Customer cust){
		String sql = "insert into customer values (?,?,?)";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, cust.getId());
			st.setString(2, cust.getName());
			st.setString(3, cust.getEmail());
			st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCustomer(Customer cust){
		String sql = "update customer set name=?, email=? where id=?";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			
			
			st.setString(1, cust.getName());
			st.setString(2, cust.getEmail());
			st.setInt(3, cust.getId());
			st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteCustomer(int id){
		String sql = "delete from customer where id=?";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			
			
			st.setInt(1, id);
			st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
