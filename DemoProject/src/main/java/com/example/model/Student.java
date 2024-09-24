package com.example.model;
import java.io.Serializable;
public class Student implements Serializable {
    //bean properties
    private long sid;
    private String name;
    private String email;
    private String address;


    //getters and setters
    public long getSid(){
        return sid;
    }
    public  void setSid(long sid){
        this.sid = sid;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

}