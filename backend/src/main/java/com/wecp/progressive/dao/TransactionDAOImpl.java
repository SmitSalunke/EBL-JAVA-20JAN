package com.wecp.progressive.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
//EBL-JAVA-20JAN
//SmitSalunke
//ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC5rvTXCuwoWKaOWjtdS8GBmfW43ONOAbjeAUR5AJIfoQkyj6WrAMTrXk4snwne0OooowYDg757X9ust+cLe3DBM1K/eBLKTFMcHjaoI8FrI1WYbAxLaY75L8IeNc5ByKD+IZcXI2/tmsEdmGdW4Jld28U2u5F9glr2Kfn1PzA/XNhp1YmWra3ytemw4XmezztAjKAe8u1jJtlh3m2ZvvHPfoKMOhngGQVuJrmXcfyUaQFEmvZK0iLQt80qOC1LLVQf4XeEh4UMPTYKYIqvolPUd22pe3eVPoxA9OoolkodOnplGPrwYbdwz5ZINIUL365JPmXaF9XfdgIo2NBtZjGqIQVshskmrTPc+UplSo43eTDHPtEZ7cCkHG/ly/dhgCUrZPOvfCRZoVO0Bg8J74MF/JqOlIKzytq8SLCj0bS8HskV2GB6GeAKH/cPkdLvZA1lF9FlAZ37dFmSOFvhPJ/JO6AOT2nDJV4fg20Fb+fZh4BH5P89QrmkvDUkpmLitlM= ubuntu@ip-172-31-1-196

import com.wecp.progressive.entity.Transactions;

public class TransactionDAOImpl {

    private static Connection connection;

    int addTransaction(Transactions transaction){
        String sql = "INSERT INTO transactions(account_id, amount, transaction_date, transaction_type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, transaction.getAccount_id());
            statement.setDouble(2, transaction.getAmount());
            statement.setDate(3, (Date) transaction.getTransaction_date());
            statement.setString(4, transaction.getTransaction_type());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                transaction.setTransaction_id(generatedKeys.getInt(1));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return 1;  //return ??
    }
    Transactions getTransactionById(int transactionId){
        String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){                
            statement.setInt(1, transactionId);

            ResultSet resultSet= statement.executeQuery();
            
            if (resultSet.next()) {         
                Transactions transaction = new Transactions();      
                transaction.setTransaction_id(resultSet.getInt("transaction_id"));
                transaction.setAccount_id(resultSet.getInt("account_id"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTransaction_date(resultSet.getDate("transaction_date"));
                transaction.setTransaction_type(resultSet.getString("transaction_type"));
                return transaction;
            } 
            
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }
    void updateTransaction(Transactions transaction){
        String sql = "update transactions set account_id=?, amount=?, transaction_date=?, transaction_type=? where transaction_id=?";
            
            try(PreparedStatement statement = connection.prepareStatement(sql)){            
            statement.setInt(1, transaction.getTransaction_id());

            int count = statement.executeUpdate();
            
            if (count > 0) {                
                System.out.println(count+" records updated.");
            } 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
    }
    void deleteTransaction(int transactionId){
        String sql = "delete from transactions where transaction_id=?";            
            try(PreparedStatement statement = connection.prepareStatement(sql)){            
            statement.setInt(1, transactionId);

            int count = statement.executeUpdate();
            
            if (count > 0) {                
                System.out.println(count+" records deleted.");
            } 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
    }

    //List<Transactions> getAllTransactions();



}
