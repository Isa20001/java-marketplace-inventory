/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplaceinventorysystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class Manager implements MarketPlaceAccess{
    private ArrayList<Product> inventory;
    
    public Manager(){
        inventory=new ArrayList<>();
    }
    
    public void showMenu(){     /**Display options to the manager***/
        System.out.println("\n-----Manager Menu------");
        System.out.println("1.View inventory ");
        System.out.println("2.Add product ");
        System.out.println("3.Remove product");
        System.out.println("4.Logout ");  
    }
    public void addProduct(Product product){
        inventory.add(product);  /**Add the product***/
        System.out.println("Product added");
    }
    public void removeProduct(String name){
        Product product = searchProduct(name);    /***Remove product by name**/
                if(product!=null){   
                   inventory.remove(product);
                   System.out.println("Product removed");
                }else{
                    System.out.println("Product not found");
                }
    }
    public Product searchProduct(String name){  /***Searching product**/
        for(Product product : inventory){
            if(product.getName().equalsIgnoreCase(name)){   /**Check if names match***/
                return product;
            }
        }
        return null;
    }
    public void viewInventory(){
        System.out.println("-----Inventory-----");
        
        for(Product product: inventory){    
            System.out.println(product);       /**Showing inventory***/
        }
    }
    public void adjustWeight(Product product,double weight){
        if(weight<=0){          /**Adjust stock quantity***/
            System.out.print("Invalid");
        }
    }
    public void logout(){
        System.out.println("Manager logged out");
    }
}