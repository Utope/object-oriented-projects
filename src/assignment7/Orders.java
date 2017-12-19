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
public class Orders {
    private ArrayList<OrderItem> orders;
    
    public Orders(){
        orders = new ArrayList<OrderItem>();
    }
    
    public ArrayList<OrderItem> getOrderItems(){
        return this.orders;
    }
    
    public OrderItem get(String name){
        Iterator<OrderItem> it = orders.iterator();
        while(it.hasNext()){
            OrderItem item = it.next();
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }
    
    public boolean contains(String name){
        Iterator<OrderItem> it = orders.iterator();
        while(it.hasNext()){
            if(it.next().getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
}
