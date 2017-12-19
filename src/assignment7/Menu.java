/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author robert
 */
public class Menu {
    private ArrayList<MenuItem> menuItems;
    
    public Menu(){
        this.menuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenuItems(){
        return this.menuItems;
    }
    
    public MenuItem get(String name){
        Iterator<MenuItem> it = menuItems.iterator();
        while(it.hasNext()){
            MenuItem item = it.next();
            if(item.getName().equals(name)){
                return item; 
            }
        }
        return null;
    }
    
    public boolean contains(String name){
        Iterator<MenuItem> it = this.menuItems.iterator();
        while(it.hasNext()){
            if(it.next().getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
