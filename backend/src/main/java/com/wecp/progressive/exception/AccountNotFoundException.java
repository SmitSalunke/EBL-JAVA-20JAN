package com.wecp.progressive.exception;

public class AccountNotFoundException extends Exception{
    AccountNotFoundException(String msg){
        super(msg);
    }
}