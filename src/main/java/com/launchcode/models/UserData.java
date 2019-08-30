package com.launchcode.models;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    //get cheese
    public static ArrayList<User> getAll(){
        return users;
    }

    //add Cheese
    public static void addUser(User user){
        users.add(user);
    }

    //get Cheese by Id
    public static User getCheeseById(int userId){
        for(User user:users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }
}