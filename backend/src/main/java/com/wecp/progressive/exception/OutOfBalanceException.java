package com.wecp.progressive.exception;

public class OutOfBalanceException extends Exception{
    OutOfBalanceException(String msg){
        super(msg);
    }
}