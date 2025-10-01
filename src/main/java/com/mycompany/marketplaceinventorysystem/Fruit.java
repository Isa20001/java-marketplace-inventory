/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplaceinventorysystem;

/**
 *
 * @author isabe
 */
public class Fruit extends Product{
    
    private String season;

    public Fruit(String name, double weight, double pricePerKg,String season) {   /**Constructor**/
        super(name, weight, pricePerKg);
        this.season=season;
    }   
    
    @Override
    public double calculatePrice(){
         return getWeight()*getPricePerKg();    /**Calculate price**/
    }
    public String toString(){   /**Print info of fruit section**/
        return super.toString()+", Season:"+season;
    }
}
    
