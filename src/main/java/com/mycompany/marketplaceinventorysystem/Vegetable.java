/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplaceinventorysystem;

/**
 *
 * @author isabe
 */
public class Vegetable extends Product {
    
    private boolean isOrganic;    /**Boolean (true if organic)**/

    public Vegetable(String name, double weight, double pricePerKg, boolean isOrganic) {  /**Constructor**/
        super(name, weight, pricePerKg);
        this.isOrganic=isOrganic;
    }
    
    @Override
    public double calculatePrice(){   
        return getWeight()*getPricePerKg();    /**Calculate price**/
    }
    public String toString(){    /**Print info of vegetables**/
        return super.toString()+", Organic:"+isOrganic;
    }
}
