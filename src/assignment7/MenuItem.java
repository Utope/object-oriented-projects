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
public class MenuItem {
    
    private String name;
    private float price;
    
    public MenuItem(String name, float price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    
    @Override
    public String toString(){
        return this.name + " : " + this.price;
    }
}
