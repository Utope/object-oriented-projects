/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 *
 * @author robert
 */
public class Tab {
    
    Orders orders;
    String timestamp;
    
    public Tab(Orders orders){
        this.orders = orders;
        this.timestamp =  new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
    }
    
    @Override
    public String toString(){
        String tab = this.timestamp + "\n";
        float total = 0.0f;
        
        Iterator<OrderItem> it = orders.getOrderItems().iterator();
        while(it.hasNext()){
            OrderItem orderItem = it.next();
            tab += orderItem.toString() + "\n";
            total += orderItem.getMenuItem().getPrice();
        }
        
        tab+= "Total Items " + orders.getOrderItems().size() + "\n";
        tab+= "Total Price $" + total;
        return tab;
    }
}
