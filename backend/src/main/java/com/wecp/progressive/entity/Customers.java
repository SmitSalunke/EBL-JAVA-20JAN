package com.wecp.progressive.entity;


public class Customers implements Comparable<Customers>{
    private int customer_id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String role; 

    public int compareTo(Customers c){
        return this.getUsername().compareTo(c.getUsername());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer_id(int customer_id){
        this.customer_id=customer_id;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setRole(String role){
        this.role=role;
    }

    public int getCustomer_id(){
        return customer_id;
    }

    public String getEmail(){
        return email;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

}
