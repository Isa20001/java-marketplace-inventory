/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplaceinventorysystem;

/**
 *
 * @author isabe
 */
public class CartItem {
    private Product product;
    private double quantity;
    private double price;
    
    public CartItem (Product product,double quantity){  /*****Constructor*****/
        this.product=product;
        this.quantity=quantity;
        this.price=price;
    }
                            /**Getters and setters***/
     public void setproduct(Product product){ 
        this.product=product;
    }
    public Product getProduct(){
        return product;
        
    } public void setQuantity(double quantity){ 
        this.quantity=quantity;
    }
    public double getQuantity(){
        return quantity;
    }
    public double calculatePrice(){   /****Calculate the price of the item*****/
        return quantity*product.getPricePerKg();
    }
    
    public String toString(){    /****Print information of cart items*****/
        return "\n"+product.getName()+ ", quantity:"+quantity+"kg, price: $"+calculatePrice();
    }    
}
