/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplaceinventorysystem;

/**
 *
 * @author isabe
 */
public class Meat extends Product{
    
    private String cutType;

    public Meat(String name, double weight, double pricePerKg, String cutType) {    /**Constructor**/
        super(name, weight, pricePerKg);
        this.cutType=cutType;
    }
    
    @Override
    public double calculatePrice(){
         return getWeight()*getPricePerKg();     /**Calculate price**/
    }
    
    public String toString(){   /**Print info of meats**/
        return super.toString()+", Cut type:"+cutType;
    }
}
