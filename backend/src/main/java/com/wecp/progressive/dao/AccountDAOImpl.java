package com.wecp.progressive.dao;
import java.sql.*;

import javax.security.auth.login.AccountNotFoundException;

import com.wecp.progressive.entity.Accounts;

public class AccountDAOImpl {
    private static Connection connection;

    int addAccount(Accounts accounts){
        String sql = "INSERT INTO accounts(customer_id, balance) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, accounts.getCustomer_id());
            statement.setDouble(2, accounts.getBalance());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                accounts.setAccount_id(generatedKeys.getInt(1));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return 1;  //return ??
    }


    Accounts getAccountById(int accountId) throws AccountNotFoundException{
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){                
            statement.setInt(1, accountId);

            ResultSet resultSet= statement.executeQuery();
            
            if (resultSet.next()) {         
                Accounts accounts = new Accounts();       
                accounts.setAccount_id(resultSet.getInt("account_id"));
                accounts.setCustomer_id(resultSet.getInt("customer_id"));
                accounts.setBalance(resultSet.getDouble("balance"));
                return accounts;
            } 
            else{
                throw new AccountNotFoundException(accountId+" not found");
            }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }


    void updateAccount(Accounts accounts){
        String sql = "update accounts set customer_id=?, balance=? where account_id=?";
            
            try(PreparedStatement statement = connection.prepareStatement(sql)){            
            statement.setInt(1, accounts.getAccount_id());

            int count = statement.executeUpdate();
            
            if (count > 0) {                
                System.out.println(count+" records updated.");
            } 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
    }


    void deleteAccount(int accountId){
        String sql = "delete from accounts where account_id=?";            
            try(PreparedStatement statement = connection.prepareStatement(sql)){            
            statement.setInt(1, accountId);

            int count = statement.executeUpdate();
            
            if (count > 0) {                
                System.out.println(count+" records deleted.");
            } 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
    }


    List<Accounts> getAllAccounts(){

    }
}
