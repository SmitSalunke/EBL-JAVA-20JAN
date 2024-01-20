package com.wecp.progressive.exception;

public class WithdrawalLimitException extends Exception{
    WithdrawalLimitException(String msg){
        super(msg);
    }
}