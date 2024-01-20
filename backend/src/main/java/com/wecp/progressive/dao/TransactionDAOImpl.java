package com.wecp.progressive.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.wecp.progressive.entity.Transactions;

public class TransactionDAOImpl {

    List<Transactions> t1 = new ArrayList<Transactions>();

    int addTransaction(Transactions transaction){
        t1.add(transaction);
        return 1;
    }
    Transactions getTransactionById(int transactionId){
        for(Transactions i: t1){
            if(i.getTransaction_id() == transactionId){
                return i;
            }
        }
        return null;
    }
    void updateTransaction(Transactions transaction){
        for(Transactions i: t1){
            if(i.getTransaction_id() == transaction.getTransaction_id()){
                t1.set(t1.indexOf(i), transaction);
            }
        }
    }
    void deleteTransaction(int transactionId){
        for(Transactions i: t1){
            if(i.getTransaction_id() == transactionId){
                t1.remove(i);
            }
        }
    }
    List<Transactions> getAllTransactions(){
        return t1;
    }



}



 // private static Connection connection;

    // int addTransaction(Transactions transaction){
    //     String sql = "INSERT INTO transactions(account_id, amount, transaction_date, transaction_type) VALUES (?, ?, ?, ?)";
    //     try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    //         statement.setInt(1, transaction.getAccount_id());
    //         statement.setDouble(2, transaction.getAmount());
    //         statement.setDate(3, (Date) transaction.getTransaction_date());
    //         statement.setString(4, transaction.getTransaction_type());
    //         statement.executeUpdate();

    //         ResultSet generatedKeys = statement.getGeneratedKeys();
    //         if (generatedKeys.next()) {
    //             transaction.setTransaction_id(generatedKeys.getInt(1));
    //         }
            
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }        
    //     return 1;  //return ??
    // }
    // Transactions getTransactionById(int transactionId){
    //     String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
    //         try(PreparedStatement statement = connection.prepareStatement(sql)){                
    //         statement.setInt(1, transactionId);

    //         ResultSet resultSet= statement.executeQuery();
            
    //         if (resultSet.next()) {         
    //             Transactions transaction = new Transactions();      
    //             transaction.setTransaction_id(resultSet.getInt("transaction_id"));
    //             transaction.setAccount_id(resultSet.getInt("account_id"));
    //             transaction.setAmount(resultSet.getDouble("amount"));
    //             transaction.setTransaction_date(resultSet.getDate("transaction_date"));
    //             transaction.setTransaction_type(resultSet.getString("transaction_type"));
    //             return transaction;
    //         } 
            
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //             return null;
    //         }
    // }
    // void updateTransaction(Transactions transaction){
    //     String sql = "update transactions set account_id=?, amount=?, transaction_date=?, transaction_type=? where transaction_id=?";
            
    //         try(PreparedStatement statement = connection.prepareStatement(sql)){            
    //         statement.setInt(1, transaction.getTransaction_id());

    //         int count = statement.executeUpdate();
            
    //         if (count > 0) {                
    //             System.out.println(count+" records updated.");
    //         } 
    //         } 
    //         catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    // }
    // void deleteTransaction(int transactionId){
    //     String sql = "delete from transactions where transaction_id=?";            
    //         try(PreparedStatement statement = connection.prepareStatement(sql)){            
    //         statement.setInt(1, transactionId);

    //         int count = statement.executeUpdate();
            
    //         if (count > 0) {                
    //             System.out.println(count+" records deleted.");
    //         } 
    //         } 
    //         catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    // }

    // //List<Transactions> getAllTransactions();
