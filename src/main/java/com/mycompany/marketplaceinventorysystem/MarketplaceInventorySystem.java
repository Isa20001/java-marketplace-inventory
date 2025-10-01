/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.marketplaceinventorysystem;

import java.util.Scanner;

/**
 **Integrity Policy: This code was created and written by the me, without any
assistance from unauthorized sources. I HAVE ABIDED BY THE UNCG ACADEMIC POLICY ON THIS ASSIGNMENT.
* Signed:Isabel Barboza
* Date:08/28/2025
* Course: CSC 330-01: Advanced Data Structures    
* Assignment: This program is a simple marketplace inventory system where Managers manage products, and users browse, add to cart, and purchase items. The inventory automatically updates stock after each purchase. 
 */
public class MarketplaceInventorySystem {          /***Hardcoded login credentials****/
        private static final String MANAGER_USERNAME ="admin";
        private static final String MANAGER_PASSWORD ="password123";
        private static final String USER_USERNAME ="customer";
        private static final String USER_PASSWORD ="guest";
    
        public static void main(String[] args) {
        System.out.println("Program Title: Marketplace Inventory System");
        System.out.println("Author: Isabel Barboza");
        System.out.println("Course: CSC 330");
        
        Scanner scanner=new Scanner(System.in);
        Manager manager=new Manager();    /***Create manager****/
        User user=new User();     /***Create user****/
            
        int number=0;
        boolean running=true;
        while(running){
        System.out.println("\n-----Marketplace Login-----");
       
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
       
        if(username.equals(MANAGER_USERNAME)&& password.equals(MANAGER_PASSWORD)){ /***Manager login****/
           System.out.println("Manager logged in");
           boolean managerBoolean=true;
           
           while(managerBoolean){
                manager.showMenu();   /****Show manager options****/
                System.out.println("Enter a number: ");
                number=scanner.nextInt();
                scanner.nextLine();   /***Clear input buffer**/
                
            switch(number){
                    case 1:
                        manager.viewInventory(); /***View list of products****/
                        break;
                    case 2:             /***Input to add a product****/
                        System.out.println("Enter number product type (1:Vegetable, 2:Fruit, 3:Meat): ");
                        int type=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter product name: ");
                        String name=scanner.nextLine();
                        System.out.println("Enter weight (kg): ");
                        double weight=scanner.nextDouble();
                        System.out.println("Enter price per kg: ");
                        double pricePerKg=scanner.nextDouble();
                        scanner.nextLine();      /***Clear input buffer**/
                        if(type==1){
                            System.out.println("Is it organic?(true/false):");
                            boolean organic=scanner.nextBoolean();
                            manager.addProduct(new Vegetable(name,weight,pricePerKg, organic));
                        }else if(type==2){
                            System.out.println("Enter season:");
                            String season=scanner.nextLine();
                            manager.addProduct(new Fruit(name,weight,pricePerKg, season));
                        }else if(type==3){
                            System.out.println("Enter cut meat type:");
                            String cutType=scanner.nextLine();
                            manager.addProduct(new Meat(name,weight,pricePerKg, cutType));
                        }else{
                            System.out.println("Invalid type");
                        }
                        break;
                    case 3:       /***Remove a product****/
                        System.out.println("Enter product name to remove: ");
                        String remove=scanner.nextLine();
                        manager.removeProduct(remove);
                        break;
                   
                    case 4:
                        managerBoolean=false;     /***Loop end****/
                        manager.logout();    
                        break;
                    default:
                        System.out.println("Invalid");
            }
           }
        }else if (username.equals(USER_USERNAME)&& password.equals(USER_PASSWORD)){   /***User login****/
            System.out.println("User logged in");
           boolean userBoolean=true;
           
           while(userBoolean){
                user.showMenu();   /****Show user options****/
                System.out.println("Enter a number: ");
                number=scanner.nextInt();
                scanner.nextLine();     /***Clear input buffer**/
                
                switch(number){
                    case 1:
                        manager.viewInventory(); /****View inventory****/
                        break;
                    case 2:
                        System.out.println("Enter product name: ");
                        String productName=scanner.nextLine();
                        Product product=manager.searchProduct(productName);
                        if(product!=null){
                            System.out.println("Enter quantity (kg): ");
                         double quantity=scanner.nextDouble();
                         scanner.nextLine();  /***Clear input buffer**/
                         user.addToCart(product, quantity);
                        }
                        break;
                    case 3:
                        user.viewCart();    /**View items on cart**/
                        break;
                    case 4:    /**Remove product from cart**/
                        System.out.println("Enter product name to removed from cart");
                        String remove=scanner.nextLine();
                        user.removeFromCart(remove);
                        break;
                    case 5:
                        user.checkout();
                        break;
                    case 6:
                        userBoolean=false;   /**Loop end**/
                        user.logout();
                        break;
                    default:
                        System.out.println("Invalid");    
                    }
                    }
                } else {
                    System.out.println("Invalid");
                }
            }
        
        }
}

