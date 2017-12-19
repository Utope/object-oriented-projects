/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author robert
 */
public class Client {
    
    MenuState menuState = MenuState.BASE;
    
    public static void main(String[] args){
       
        Client client = new Client();
        client.loop();     
        
    }
    
    public void loop(){
        boolean cont = true;

         while(cont){
            switch(menuState){
                case DISPLAYMENU:
                        Restaurant.Instance().displayMenu();
                        
                        
                        String input = (String) Client.prompt("Type the name of the item to order it or type q to go back to base menu");
                        
                        switch(input){
                            case "q":
                                menuState = MenuState.BASE;
                                break;
                            default:
                                if(Restaurant.Instance().getMenu().contains(input)){
                                    Restaurant.Instance().addOrderItem(input);
                                    System.out.println("Added " + input + " to order... ");
                                    
                                }else{
                                    System.out.println("Item name doesnt exist...");
                                }
                                menuState = MenuState.BASE;
                                break;
                                            
                        }
                        
                    break;
                case DISPLAYTAB:
                    Restaurant.Instance().displayTab();
                    menuState = menuState.BASE;
                    break;
                case SUBMITORDER:
                    Restaurant.Instance().submitOrder();
                    menuState = menuState.BASE;
                    break;
                case DISPLAYORDER:
                    Iterator<OrderItem> it = Restaurant.Instance().getOrders().getOrderItems().iterator();
                    while(it.hasNext()){
                        System.out.println(it.next().getMenuItem());
                    }
                    break;
                case BASE:
                    baseMenu();
                    break;
            }
        }
}
    
    public void baseMenu(){
        String string = "~~~ Base Menu ~~~\n";
        string += "1.) Display Menu\n";
        string += "2.) Display Tab\n";
        string += "3.) Submit Order\n";
        
        System.out.println(string);
        String baseInput = (String) Client.prompt("Select Option : ");
                    
        switch (baseInput){
            case "1":
                menuState = MenuState.DISPLAYMENU;
                break;
            case "2":
                menuState = MenuState.DISPLAYTAB;
                break;
            case "3":
                menuState = MenuState.SUBMITORDER;
                break;
        } 
           
    }
    
    public static Object prompt(String question){
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }
}
