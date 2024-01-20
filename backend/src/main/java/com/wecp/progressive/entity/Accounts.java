package com.wecp.progressive.entity;
import java.util.*;


public class Accounts implements Comparable<Accounts>{
    private int account_id;
    private int customer_id;
    private double balance;

    public int compareTo(Accounts a){
        if(this.getBalance()>a.getBalance()){
            return 1;
        }
        if(this.getBalance()<a.getBalance()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public int getAccount_id() {
        return account_id;
    }
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

}