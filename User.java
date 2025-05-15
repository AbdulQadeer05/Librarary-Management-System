package com.example.library_managment_system;
import java.util.*;

public abstract class User {
    public int userId;
    public String userName;

    public User(int userId, String userName) {
        this.userId=userId;
        this.userName=userName;
    }

    public void displayUserInfo(){

      System.out.println("User Id :"+userId +"User Name :"+userName);
   }

}
