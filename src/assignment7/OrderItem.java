/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 *
 * @author robert
 */
public class OrderItem {
    
    private MenuItem menuItem;
    
    public OrderItem(MenuItem menuItem){
        this.menuItem = menuItem;
    }
    
    public MenuItem getMenuItem(){
        return this.menuItem;
    }
    
    public float getPrice(){
        return menuItem.getPrice();
    }
    
    public String getName(){
        return menuItem.getName();
    }
    
    public String toString(){
        return menuItem.toString();
    }
    
    
}
