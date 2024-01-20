package com.wecp.progressive.dao;
import java.sql.*;
import java.util.*;

import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.exception.CustomerAlreadyExistsException;

public class CustomerDAOImpl implements CustomerDAO{

    List<Customers> c1 = new ArrayList<Customers>();

    public int addCustomer(Customers customers){
        c1.add(customers);
        return 1;
    }

    public Customers getCustomerById(int customerId){
        for(Customers i: c1){
            if(i.getCustomer_id() == customerId){
                return i;
            }
        }
        return null;
    }
    public void updateCustomer(Customers customers){
        for(Customers i: c1){
            if(i.getCustomer_id() == customers.getCustomer_id()){
                c1.set(c1.indexOf(i), customers);
            }
        }
    }
    public void deleteCustomer(int customerId){
        for(Customers i: c1){
            if(i.getCustomer_id() == customerId){
                c1.remove(i);
            }
        }

    }
    public List<Customers> getAllCustomers(){
        return c1;
    }

    CustomerAccountInfo c2 = new CustomerAccountInfo();
    public CustomerAccountInfo getCustomerAccountInfo(int customerId){
        return c2;
    }

    
}






// private static Connection connection;

    // int addCustomer(Customers customers){
    //     String sql = "INSERT INTO customers(name, email, username, password, role) VALUES (?, ?, ?, ?, ?)";
    //     try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    //         statement.setString(1, customers.getName());
    //         statement.setString(2, customers.getEmail());
    //         statement.setString(3, customers.getUsername());
    //         statement.setString(4, customers.getPassword());
    //         statement.setString(5, customers.getRole());
    //         statement.executeUpdate();

    //         ResultSet generatedKeys = statement.getGeneratedKeys();
    //         if (generatedKeys.next()) {
    //             customers.setCustomer_id(generatedKeys.getInt(1));
    //         }
            
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }        
    //     return 1;  //return ??
    // }

    // Customers getCustomerById(int customerId) throws CustomerAlreadyExistsException{
    //     String sql = "SELECT * FROM customers WHERE customer_id = ?";
    //         try(PreparedStatement statement = connection.prepareStatement(sql)){                
    //         statement.setInt(1, customerId);

    //         ResultSet resultSet= statement.executeQuery();
            
    //         if (resultSet.next()) {         
    //             Customers customers = new Customers();      
    //             customers.setCustomer_id(resultSet.getInt("customer_id"));
    //             customers.setName(resultSet.getString("name"));
    //             customers.setEmail(resultSet.getString("email"));
    //             customers.setUsername(resultSet.getString("username"));
    //             customers.setPassword(resultSet.getString("password"));
    //             customers.setRole(resultSet.getString("role"));
    //             return customers;
    //         } 
    //         else{
    //             throw new CustomerAlreadyExistsException(customerId+" not found");
    //         }
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //             return null;
    //         }
    // }
    // void updateCustomer(Customers customers){
    //     String sql = "update customers set name=?, email=?, username=?, password=?, role=? where customer_id=?";
            
    //         try(PreparedStatement statement = connection.prepareStatement(sql)){            
    //         statement.setInt(1, customers.getCustomer_id());

    //         int count = statement.executeUpdate();
            
    //         if (count > 0) {                
    //             System.out.println(count+" records updated.");
    //         } 
    //         } 
    //         catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    // }
    // void deleteCustomer(int customerId){
    //     String sql = "delete from customers where customer_id=?";            
    //         try(PreparedStatement statement = connection.prepareStatement(sql)){            
    //         statement.setInt(1, customerId);

    //         int count = statement.executeUpdate();
            
    //         if (count > 0) {                
    //             System.out.println(count+" records deleted.");
    //         } 
    //         } 
    //         catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    // }
    // List<Customers> getAllCustomers();
    // CustomerAccountInfo getCustomerAccountInfo(int customerId);

