package com.launchcode.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    //get cheese
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    //update Cheese
    public static void updateCheese(int cheeseId, String name, String desc,String type,int rating){
        Cheese cheese = getCheeseById(cheeseId);
        cheese.setName(name);
        cheese.setDescription(desc);
        cheese.setType(CheeseType.valueOf(type));
        cheese.setRating(rating);
    }

    //add Cheese
    public static void addCheese(Cheese newCheese){
        cheeses.add(newCheese);
    }

    //delete cheese
    public static void deleteCheese(int id){
        Cheese cheeseToRemove = getCheeseById(id);
        cheeses.remove(cheeseToRemove);
    }

    //get Cheese by Id
    public static Cheese getCheeseById(int cheeseId){
        for(Cheese cheese:cheeses){
            if(cheese.getCheeseId() == cheeseId){
                return cheese;
            }
        }
        return null;
    }
}
