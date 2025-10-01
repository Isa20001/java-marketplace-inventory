/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplaceinventorysystem;

/**
 *
 * @author isabe
 */
 public abstract class Product {
    private String name;
    private double weight;  
    private double pricePerKg;
    
    public Product (String name,double weight,double pricePerKg){  /***Constructor***/
        this.name=name;
        this.weight=weight;
        this.pricePerKg=pricePerKg;
    }
                /**Getters and setters***/
    public String getName(){
        return name;
    }
    public String toString(){    /*** Show info of products****/
        return "\n"+name+ ", Weigth:"+weight+"kg, Price: $"+pricePerKg+"/kg";
    }
    public void setWeight(double weight){ 
        this.weight=weight;
    }
    public double getWeight(){
        return weight;
    }
    public void setPricePerKg(double pricePerKg){
        this.pricePerKg=pricePerKg; 
    }
    public double getPricePerKg(){
        return pricePerKg;
    }
     public abstract double calculatePrice(); /**Calculate price for this product**/
    
}
