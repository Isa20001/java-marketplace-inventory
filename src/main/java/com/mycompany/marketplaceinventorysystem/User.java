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
public class User implements MarketPlaceAccess{
    private ArrayList<CartItem> cart; 
             Scanner scanner=new Scanner(System.in);
    public User(){
        cart= new ArrayList<>();
        }
  
     public void showMenu(){  /***Show the menu***/
        System.out.println("\n------User Menu------");
        System.out.println("1.View inventory ");
        System.out.println("2.Add to cart ");
        System.out.println("3.View cart ");
        System.out.println("4.Remove from cart");
        System.out.println("5.Checkout ");
        System.out.println("6.Logout ");
     }
    
     public void addToCart(Product product,double quantity){ /***Add item products to cart***/
         if(quantity<=0){
             System.out.println("Invalid quantity");
             return;
         }
         cart.add(new CartItem(product, quantity));
           System.out.println("Added "+quantity+"kg of "+product.getName()+" to the cart.");
    }
    public void removeFromCart(String productName){  
        CartItem remove = null;
        for(CartItem item: cart){
            if(item.getProduct().getName().equalsIgnoreCase(productName)){    /**Check if names match***/
            remove=item;
            break;
            } 
           }
            if (remove!=null){
            cart.remove(remove);    /***Remove item products from cart***/
            System.out.println("Item removed from cart");
            }else{
            System.out.println("Item not found");
            }
        }

    public void viewCart(){  
        System.out.print("----Cart Items----");
        if(cart.isEmpty()){
            System.out.println("\nThere is not items in the cart. ");
            return;
        }
        for(CartItem item: cart){      
            System.out.println(item);      /***Display items in cart***/
        }
    }
    public void checkout(){
        double total=0;
        System.out.println("----Checkout----");
        for (CartItem item : cart){
            Product product=item.getProduct();
            if(item.getQuantity()<=product.getWeight()){    /***Check if there is enough products***/
                double itemTotal=item.calculatePrice();
                total+=itemTotal;
                product.setWeight(product.getWeight() - item.getQuantity());  /***Updates the stock***/
                System.out.println(item.getProduct().getName()+" - "+item.getQuantity()+"kg @ $"+ product.getPricePerKg()+"/kg, Total:$"+ itemTotal); 
            } else{
           System.out.println("Not enough items"); 
            }
        }
        
        System.out.println("Total payment:$" +total);
        System.out.println("\nThanks for your purchase!");
        cart.clear();   /***Empty the cart***/
    }
    public void logout(){
        System.out.println("User logged out");
    }
}
