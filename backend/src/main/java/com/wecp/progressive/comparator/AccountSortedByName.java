package com.wecp.progressive.comparator;

import java.util.*;

import com.wecp.progressive.entity.Customers;

public class AccountSortedByName implements Comparator<Customers>{

    public int compare(Customers c1, Customers c2){
        return c1.getName().compareTo(c2.getName());
    }
    
}
